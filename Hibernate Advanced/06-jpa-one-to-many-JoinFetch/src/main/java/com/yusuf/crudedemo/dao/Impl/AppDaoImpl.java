package com.yusuf.crudedemo.dao.Impl;

import com.yusuf.crudedemo.dao.AppDao;
import com.yusuf.crudedemo.entity.Course;
import com.yusuf.crudedemo.entity.Instructor;
import com.yusuf.crudedemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager entityManager;


    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);


        // remove the associated object reference
        // break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    // lazy loading yani ihtiyaç olduğunda getir.
    @Override
    public List<Course> findCoursesByInstructor(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data",Course.class);

        query.setParameter("data",theId);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                + "JOIN FETCH i.courses "
                + "where i.id = :data", Instructor.class);
        query.setParameter("data",theId);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }
}
