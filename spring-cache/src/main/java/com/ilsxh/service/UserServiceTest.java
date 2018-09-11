package com.ilsxh.service;

import com.ilsxh.config.AppConfig;
import com.ilsxh.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;


public class UserServiceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean(UserService.class);
        User user1 = userService.getUser(1);
        System.out.println(user1);

        User user2 = userService.getUser(2);
        System.out.println(user2);
    }

}