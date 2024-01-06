package com.yusuf.crudedemo.dao;

import com.yusuf.crudedemo.entity.Course;
import com.yusuf.crudedemo.entity.Instructor;
import com.yusuf.crudedemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructor(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor instructor);

}
