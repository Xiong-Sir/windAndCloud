package com.windAndCloud.service.impl;

import com.windAndCloud.entity.ShoppUser;
import com.windAndCloud.mapper.ShoppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 代号：9527
 * @email fj0120@yeah.net
 * @date 2020/9/7 0007 15:43
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    ShoppUserMapper shoppUserMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
