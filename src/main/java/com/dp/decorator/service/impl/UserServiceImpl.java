package com.dp.decorator.service.impl;

import com.dp.decorator.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public String getUserName(int id) {
        return "admin";
    }
}
