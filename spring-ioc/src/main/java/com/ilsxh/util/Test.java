package com.ilsxh.util;

import com.ilsxh.service.IndexService;

public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        IndexService cityService = (IndexService) applicationContext.getBean("IndexService.class");
        cityService.index();
    }
}
