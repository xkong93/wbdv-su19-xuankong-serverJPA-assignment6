package com.example.wbdvsu19xuankongmyappassignment6.controller;

import com.example.wbdvsu19xuankongmyappassignment6.models.Course;
import com.example.wbdvsu19xuankongmyappassignment6.services.CourseService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-13.
 */


@RestController
@CrossOrigin("*")
public class CourseController {
  CourseService service;

  CourseController() {
    service = new CourseService();
  }

  @PostMapping("/api/courses")
  public List<Course> createCourse (
          @RequestBody Course newCourse){
    service.createCourse(newCourse);
    return service.findAllCourses();
  }

  @GetMapping("/api/courses")
  public List<Course> findAllCourses(){
    return service.findAllCourses();
  }

  @GetMapping("/api/courses/{cid}")
  public Course findCourseById(@PathVariable("cid") Long cid){
    return service.findCourseById(cid);
  }


  @PutMapping("/api/courses/{cid}")
  public Course updateCourse(
          @PathVariable("cid") Long cid,
          @RequestBody Course course){
    return service.updateCourse(cid,course);
  }

  @DeleteMapping("/api/courses/{cid}")
  public void deleteCourse(
          @PathVariable("cid") Long cid){
    service.deleteCourse(cid);
  }

}
