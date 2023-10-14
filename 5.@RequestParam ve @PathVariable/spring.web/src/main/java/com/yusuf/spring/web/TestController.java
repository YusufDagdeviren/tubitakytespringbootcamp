package com.yusuf.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @RequestMapping("/courses/{courseNumber}")
    public void test(@PathVariable Long courseNumber, @RequestParam String name,@RequestParam String instructor){
        System.out.println(courseNumber+" "+name+" "+instructor);
    }
}
