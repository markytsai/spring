package com.ilsxh.service;

import com.ilsxh.annotation.Component;
import com.ilsxh.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class IndexService {
    @Autowired
    IndexDao indexDao;

    public void index() {
        System.out.println("IndexService");
        indexDao.index();
    }
}
