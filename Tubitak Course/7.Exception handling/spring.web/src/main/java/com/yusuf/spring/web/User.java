package com.yusuf.spring.web;

import jakarta.validation.constraints.*;

import java.time.LocalDate;


public class User {
    @NotBlank(message = "Name must is not empty")
    private String name;
    @NotBlank(message = "Surname must is not empty")
    private String surname;
    private int age;
    private String identifyNumber;
    @NotBlank(message = "Username must is not empty")
    private String userName;
    @NotBlank(message = "Email must is not empty")
    @Email
    private String email;
    @PastOrPresent
    private LocalDate birthdate;
    @Size(max = 250)
    private String address;
    @AssertTrue
    public boolean isAgeValid(){
        return age>12 && age<100;
    }
    @AssertTrue
    public boolean isUsernameValid(){
        return !userName.equals("admin");
    }

}
