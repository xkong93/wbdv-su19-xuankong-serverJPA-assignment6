package com.example.wbdvsu19xuankongmyappassignment6.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Xuan Kong
 * @Date 2019-06-18.
 */
@Entity
@Table(name = "modules")
public class Module {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;


  @ManyToOne
  @JsonIgnore
  private Course course;

  @Transient
  public String getCourseTitle() {
    return course.getTitle();
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


}
