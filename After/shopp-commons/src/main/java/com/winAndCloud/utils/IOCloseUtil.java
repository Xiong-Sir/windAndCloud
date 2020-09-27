package com.winAndCloud.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.io.IOException;
@Slf4j
/**
 * 关闭资源工具
 */
public class IOCloseUtil {

	private IOCloseUtil(){

	}
	
	/**
	 * 关闭需要关闭的资源
	 * @param cls
	 */
	public static void safeClose(Closeable cls) {
		if (cls != null) {
			try {
				cls.close();
			} catch (IOException e) {
				log.error("close writer error:{}" ,e.getMessage(),e);
			}
		}
	}

}
