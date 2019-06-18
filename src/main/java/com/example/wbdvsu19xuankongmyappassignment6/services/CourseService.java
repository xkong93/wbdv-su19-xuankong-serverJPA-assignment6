package com.example.wbdvsu19xuankongmyappassignment6.services;

import com.example.wbdvsu19xuankongmyappassignment6.models.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-13.
 */
public class CourseService {

  public static List<Course> courses = new ArrayList<>();

  static{
    courses.add(new Course((long)123,"CS5610","me","Today"));
    courses.add(new Course((long)456,"CS5200","me","Today"));
    courses.add(new Course((long)789,"Course 3","me","Today"));
    courses.add(new Course((long)888,"Course 4","me","Today"));
  }

  public List<Course> createCourse(Course newCourse){
    courses.add(newCourse);
    return courses;
  }

  public List<Course> findAllCourses(){
    return courses;
  }

  public Course findCourseById(Long cid){
    for (Course course : courses){
      if (course.getId().equals(cid)){
        return course;
      }
    }
    return null;
  }

  public Course updateCourse(Long cid, Course newCourse){
    for (Course course : courses){
      if (course.getId().equals(cid)){
        course.setTitle(newCourse.getTitle());
        course.setOwner(newCourse.getOwner());
        course.setModifiedDate(newCourse.getModifiedDate());
        return course;
      }
    }

    return null;
  }

  public void deleteCourse(Long cid){
      for (int i = 0; i < courses.size(); i++){
        if (courses.get(i).getId().equals(cid)){
          courses.remove(i);
        }
      }
  }

}
