package com.graphqljava.little_vote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.graphqljava.little_vote.Mapper")
@EnableCaching // 开启缓存
@EnableTransactionManagement // 开启事务，保证redis与mysql中数据的一致性
public class LittleVoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleVoteApplication.class, args);
    }

}
