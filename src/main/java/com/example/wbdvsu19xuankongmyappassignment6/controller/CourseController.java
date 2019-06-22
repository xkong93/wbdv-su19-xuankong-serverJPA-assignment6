package com.example.wbdvsu19xuankongmyappassignment6.controller;

import com.example.wbdvsu19xuankongmyappassignment6.models.Course;
import com.example.wbdvsu19xuankongmyappassignment6.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  CourseService service;

  @PostMapping("/api/course")
  public List<Course> createCourse (
          @RequestBody Course newCourse){
    return service.createCourse(newCourse);
  }

  @GetMapping("/api/course")
  public List<Course> findAllCourses(){
    return service.findAllCourses();
  }

  @GetMapping("/api/course/{cid}")
  public Course findCourseById(@PathVariable("cid") Long cid){
    return service.findCourseById(cid);
  }

  @PutMapping("/api/course/{cid}")
  public Course updateCourse(
          @PathVariable("cid") Long cid,
          @RequestBody Course course){
    return service.updateCourse(cid,course);
  }

  @DeleteMapping("/api/course/{cid}")
  public void deleteCourse(
          @PathVariable("cid") Long cid){
    service.deleteCourse(cid);
  }

//  @PostMapping("/api/courses/{cid}/modules/{mid}")
//  public void

}
