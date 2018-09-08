package com.ilsxh.service;

import com.ilsxh.util.AnnotationConfigApplicationContext;

public class CityServiceTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        IndexService cityService = (IndexService) applicationContext.getBean("IndexService.class");
        cityService.index();

    }

}