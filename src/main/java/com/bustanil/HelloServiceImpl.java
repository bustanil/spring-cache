package com.bustanil;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {


    @Override
    @Cacheable("test")
    public String sayHello() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello world";
    }
}
