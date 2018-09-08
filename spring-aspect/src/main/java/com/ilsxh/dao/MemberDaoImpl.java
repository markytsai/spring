package com.ilsxh.dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class MemberDaoImpl implements MemberDao {

    @Override
    public final void query() {
        System.out.println("make queriees");
    }

    @Override
    public void update() {
        System.out.println("update");
    }
}
