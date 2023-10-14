package com.yusuf.spring.demoproject;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean {
    public void print(){
        System.out.println("I am print function");
    }
    @PostConstruct
    public void postPrint(){
        System.out.println("I am postPrint function");

    }
    @PreDestroy
    public void destroyPrint(){
        System.out.println("I am preDestroy function");

    }
    public LifecycleBean(){
        System.out.println("I am constructor");
    }
}
