package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "You must swimming everyday for 2 hours";
    }
}
