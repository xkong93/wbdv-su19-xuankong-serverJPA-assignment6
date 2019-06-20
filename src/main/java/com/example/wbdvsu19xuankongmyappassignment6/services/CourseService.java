package com.example.wbdvsu19xuankongmyappassignment6.services;

import com.example.wbdvsu19xuankongmyappassignment6.models.Course;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-13.
 */
@Service
public class CourseService {

  @Autowired
  private CourseRepository repository;


  public List<Course> createCourse(Course newCourse) {
    repository.save(newCourse);
    return findAllCourses();
  }

  public List<Course> findAllCourses() {
    List<Course> lists = (List<Course>) repository.findAll();
    return lists;
  }


  public Course findCourseById(Long cid) {
    Course course = repository.findById(cid).get();
    return course;
  }

  public Course updateCourse(Long cid, Course newCourse) {
    Course course = repository.findById(cid).get();
    if (course != null) {
      course.setTitle(newCourse.getTitle());
      course.setOwner(newCourse.getOwner());
      course.setModifiedDate(newCourse.getModifiedDate());
      repository.save(course);
      return course;
    }
    return null;
  }

  public void deleteCourse(Long cid) {
    repository.deleteById(cid);

  }

}
