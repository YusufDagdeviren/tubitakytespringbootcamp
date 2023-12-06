package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> getAllStudentsOrderByLastname() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("From Student order by lastname", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> getStudentByLastname(String lastname) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("From Student where lastname=:thedata", Student.class);
        typedQuery.setParameter("thedata", lastname);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentFromId(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        return entityManager.createQuery("Delete From Student").executeUpdate();
    }

    @Override
    @Transactional
    public int deleteStudentsFromLastName(String name) {
        Query query = entityManager.createQuery("Delete From Student WHERE lastname=:data");
        return query.setParameter("data",name).executeUpdate();
    }
}
