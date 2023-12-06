package com.yusuf.spring.demoproject;


import org.springframework.stereotype.Component;

@Component
public class SetterInjectionBean {
    public void print(){
        System.out.println("Ben bir setterInjection bean'iyim");
    }
}
