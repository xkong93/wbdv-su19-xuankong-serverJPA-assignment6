package com.example.wbdvsu19xuankongmyappassignment6.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Xuan Kong
 * @Date 2019-06-10.
 */


@Entity
@Table(name = "courses")
public class Course {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String owner;
  private String modifiedDate;


  //reason: course might have several one to many relationships
  // so it needs use mappedBy to identify which obj you want to map
  @OneToMany(mappedBy = "course" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<Module> modules;


  public Course() {

  }

  public Course(Long id, String title, String owner, String modifiedDate) {
    this.id = id;
    this.title = title;
    this.owner = owner;
    this.modifiedDate = modifiedDate;
  }

  public List<Module> getModules() {
    return modules;
  }

  public void setModules(List<Module> modules) {
    this.modules = modules;
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

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(String modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  @Override
  public String toString() {
    return "Course{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", owner='" + owner + '\'' +
            ", modifiedDate='" + modifiedDate + '\'' +
            ", modules=" + modules +
            '}';
  }
}
