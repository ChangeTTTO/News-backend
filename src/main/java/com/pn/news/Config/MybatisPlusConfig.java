package com.pn.news.Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.pn.news.Mapper")
public class MybatisPlusConfig {
}
