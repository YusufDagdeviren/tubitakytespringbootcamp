package com.yusuf.spring.demoproject;


import org.springframework.stereotype.Component;

@Component
public class FieldInjectionBean {
    public void print(){
        System.out.println("Ben bir fieldinjection bean'iyim");
    }
}
