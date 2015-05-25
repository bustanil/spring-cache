package com.bustanil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class App implements CommandLineRunner {

    @Autowired
    HelloService helloService;

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("test");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloService.sayHello());
        System.out.println(System.currentTimeMillis());
        System.out.println(helloService.sayHello());
        System.out.println(System.currentTimeMillis());
        System.out.println(helloService.sayHello());
        System.out.println(System.currentTimeMillis());
        System.out.println(helloService.sayHello());
    }
}
