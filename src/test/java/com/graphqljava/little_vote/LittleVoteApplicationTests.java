package com.graphqljava.little_vote;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class LittleVoteApplicationTests {
//    @Autowired
//    private RedisUtils redisUtils;
//    @Test
//    void contextLoads() {
//        redisUtils.set("redis_key", "redis_vale");
//        String value = redisUtils.get("redis_key");
//        System.out.println("输出:"+value);
//    }
}
