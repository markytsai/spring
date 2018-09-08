package com.ilsxh.config;

import com.ilsxh.dao.MemberDao;
import com.ilsxh.dao.MemberDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.ilsxh")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
