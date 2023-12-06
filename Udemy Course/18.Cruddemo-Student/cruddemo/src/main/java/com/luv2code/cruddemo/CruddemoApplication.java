package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			getStudent(studentDAO,1);
//			getStudent(studentDAO,2);
//			getStudent(studentDAO,3);
//			getStudent(studentDAO,4);
//			getAllStudent(studentDAO);
//			getAllStudentOrderByLastname(studentDAO);
//			getStudentByLastname(studentDAO,"Souza");
//          updateStudent(studentDAO);
//          deleteStudentFromId(studentDAO);
//          deleteStudentsFromLastName(studentDAO);
            deleteAllStudents(studentDAO);
        };

    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int deleteRowsCount = studentDAO.deleteAllStudents();
        System.out.println("Number of students deleted: "+ deleteRowsCount);
    }

    private void deleteStudentsFromLastName(StudentDAO studentDAO) {
        int deleteRowsCount = studentDAO.deleteStudentsFromLastName("Rodrigues");
        System.out.println("Number of students deleted: "+ deleteRowsCount);
    }

    private void deleteStudentFromId(StudentDAO studentDAO) {
        int id = 1;
        studentDAO.deleteStudentFromId(id);
        System.out.println("Deleting students id: "+id);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(3);
        student.setEmail("alexdesouza@gmail.com");
        studentDAO.update(student);
        System.out.println("Update from Students: " + student);
    }

    private void getStudentByLastname(StudentDAO studentDAO, String lastName) {
        List<Student> studentList = studentDAO.getStudentByLastname(lastName);
        for (Student student : studentList) {
            System.out.println("Id of the student you are looking for: " + student.getId());
            System.out.println("Name of the student you are looking for: " + student.getFirstname());
            System.out.println("Surname of the student you are looking for: " + student.getLastname());
            System.out.println("Email of the student you are looking for: " + student.getEmail());
            System.out.println("****************");
        }
    }

    private void getAllStudentOrderByLastname(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.getAllStudentsOrderByLastname();
        for (Student student : studentList) {
            System.out.println("Id of the student you are looking for: " + student.getId());
            System.out.println("Name of the student you are looking for: " + student.getFirstname());
            System.out.println("Surname of the student you are looking for: " + student.getLastname());
            System.out.println("Email of the student you are looking for: " + student.getEmail());
            System.out.println("****************");
        }
    }

    private void getAllStudent(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.getAllStudents();
        for (Student student : studentList) {
            System.out.println("Id of the student you are looking for: " + student.getId());
            System.out.println("Name of the student you are looking for: " + student.getFirstname());
            System.out.println("Surname of the student you are looking for: " + student.getLastname());
            System.out.println("Email of the student you are looking for: " + student.getEmail());
            System.out.println("****************");
        }
    }

    private void getStudent(StudentDAO studentDAO, int id) {
        Student student = studentDAO.findById(id);
        System.out.println("Name of the student you are looking for: " + student.getFirstname());
        System.out.println("Surname of the student you are looking for: " + student.getLastname());
        System.out.println("Email of the student you are looking for: " + student.getEmail());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple student
        System.out.println("Creating 3new student object ...");

        Student student = new Student("Fred", "Rodrigues", "fred@gmail.com");
        Student student1 = new Student("Alex", "Souza", "alex@gmail.com");
        Student student2 = new Student("Dusan", "Tadic", "dusan@gmail.com");

        // save the student objects
        System.out.println("Saving All students");
        studentDAO.save(student);
        studentDAO.save(student1);
        studentDAO.save(student2);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ...");
        Student student = new Student("Paul", "Doe", "paul@gmail.com");
        // save the student object
        System.out.println("Saving the student");
        studentDAO.save(student);
        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }
}
