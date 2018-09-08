package com.ilsxh.dao;

import com.ilsxh.entity.User;
import org.apache.ibatis.annotations.Select;


public interface UserDao {

    @Select("select username, password from user where uid = 1")
    public User query();
}
