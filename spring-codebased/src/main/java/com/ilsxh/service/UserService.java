package com.ilsxh.service;

import com.ilsxh.dao.UserDao;
import com.ilsxh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UserService {

    @Autowired
    UserDao userDao;

    public User query() {
        return userDao.query();
    }
}
