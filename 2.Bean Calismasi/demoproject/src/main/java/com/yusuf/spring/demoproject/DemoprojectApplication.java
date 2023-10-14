package com.yusuf.spring.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoprojectApplication.class, args);

		LifecycleBean lifecycleBean = context.getBean(LifecycleBean.class);

		lifecycleBean.print();
	}
	// I am constructor
	// I am postprint function
	// I am print function
	// I am preDestroy function

}
