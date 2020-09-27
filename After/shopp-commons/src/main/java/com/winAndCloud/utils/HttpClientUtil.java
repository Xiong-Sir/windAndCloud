package com.winAndCloud.utils;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


@Component
public class HttpClientUtil {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	  * @description: 调用第三方接口平台
	  * @param body 请求体
	  * @param header 请求头包含access_token
	  * @param url URL
	  * @param method  请求方式：HttpMethod.POST
	  * @return:(返回值说明) 
	  */
	public Map applyToken(LinkedMultiValueMap<String, String> header, LinkedMultiValueMap<String, String> body, String url, HttpMethod method) {
		// 总服务器地址
		String authUrl = url;

		// 请求封装体
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, header);

		// 设置restTemplate远程调用时候，对400和401不让报错，正确返回数据
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				if (response.getRawStatusCode() != 400 && response.getRawStatusCode() != 401) {
					super.handleError(response);
				}
			}
		});

		ResponseEntity<Map> exchange = restTemplate.exchange(authUrl, method, httpEntity, Map.class);
		return exchange.getBody();
	}

}
