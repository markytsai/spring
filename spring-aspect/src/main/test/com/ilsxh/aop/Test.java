package com.ilsxh.aop;

import com.ilsxh.config.AppConfig;
import com.ilsxh.service.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();

        MyBean myBean = (MyBean) applicationContext.getBean(MyBean.class);
        myBean.sayHello();
    }

}