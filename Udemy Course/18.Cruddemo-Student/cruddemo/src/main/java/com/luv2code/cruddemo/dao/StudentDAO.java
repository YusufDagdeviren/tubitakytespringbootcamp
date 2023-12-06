package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> getAllStudents();

    List<Student> getAllStudentsOrderByLastname();

    List<Student> getStudentByLastname(String lastname);

    void update(Student student);

    void deleteStudentFromId(int id);

    int deleteAllStudents();

    int deleteStudentsFromLastName(String name);


}
