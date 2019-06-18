package com.example.wbdvsu19xuankongmyappassignment6.models;

/**
 * @author Xuan Kong
 * @Date 2019-06-10.
 */
public class Course {
  private Long id;
  private String title;
  private String owner;
  private String modifiedDate;
  public Course(){

  }

  public Course(Long id, String title, String owner, String modifiedDate) {
    this.id = id;
    this.title = title;
    this.owner = owner;
    this.modifiedDate = modifiedDate;
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
}
