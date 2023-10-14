package com.yusuf.spring.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoprojectApplication.class, args);

		DepedencyInjectionTest depedencyInjectionTest = context.getBean(DepedencyInjectionTest.class);

		depedencyInjectionTest.print();
	}

}
