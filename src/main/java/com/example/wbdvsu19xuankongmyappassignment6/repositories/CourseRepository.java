package com.example.wbdvsu19xuankongmyappassignment6.repositories;

import com.example.wbdvsu19xuankongmyappassignment6.models.Course;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-18.
 */

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
//    @Query("select course from Course course where course.id=:cid")
//    public Course findCourseById(@Param("cid") Integer id);
}
