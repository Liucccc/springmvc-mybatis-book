package com.Liucccc;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * com.Liucccc
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
public class RedisTest extends BaseJunit4Test {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest() {
        redisTemplate.opsForValue().set("name", "Liuccc");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
