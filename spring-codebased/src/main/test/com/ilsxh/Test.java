package com.ilsxh;

import com.ilsxh.config.AppConfig;
import com.ilsxh.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println(userService.query().toString());
    }
}

