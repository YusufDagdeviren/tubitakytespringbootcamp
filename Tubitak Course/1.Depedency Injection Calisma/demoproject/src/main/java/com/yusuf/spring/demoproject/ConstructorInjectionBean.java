package com.yusuf.spring.demoproject;

import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionBean {
    public void print(){
        System.out.println("Ben bir constructorInjection bean'iyim");
    }
}
