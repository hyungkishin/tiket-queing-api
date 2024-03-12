package com.target.queuingapi;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisServer;

import java.io.IOException;

@TestConfiguration
public class EmbeddedRedis {

    // redis embedded package 에 들어있는 redis server 를 사용
    private final RedisServer redisServer;


    public EmbeddedRedis() throws IOException {
        this.redisServer = new RedisServer(63790);
    }

    @PostConstruct
    public void start() throws IOException {
        this.redisServer.start();
    }

    @PreDestroy
    public void step() throws IOException {
        this.redisServer.stop();
    }


}
