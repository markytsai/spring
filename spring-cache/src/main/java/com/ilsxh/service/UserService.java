package com.ilsxh.service;

import com.ilsxh.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {

    private Map<Integer, User> users = new HashMap<>();

    {
        users.put(1, new User(1, "cai"));
        users.put(1, new User(1, "zhen"));
    }

    @Cacheable(value = "users")
    public User getUser(Integer id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }
}
