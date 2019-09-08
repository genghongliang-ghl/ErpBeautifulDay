package com.erp.service;

import com.erp.mapper.UserMapper;
import com.erp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Du
 * @date : 2019/8/24 21:31
 * @description :
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        List<User> users = userMapper.select(user);
        if (users.size() != 1) {
            return null;
        }
        return users.get(0);
    }
}
