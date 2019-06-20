package com.example.wbdvsu19xuankongmyappassignment6.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Xuan Kong
 * @Date 2019-06-10.
 */

@Entity
@Table(name = "widgets")
public class Widget {
  public enum Type {
    HEADING,
    PARAGRAPH,
    IMAGE,
    LINK,
    LIST,
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Enumerated(EnumType.STRING)
  private Type type;
  private String name;
  private String size;
  private String text;
  private String src;
  private String isOrder;

  @ManyToOne
  @JsonIgnore
  private Topic topic;

  public Widget() {
  }

  public Widget(Type type, String name, String size, String text, String src, String isOrder) {

    this.type = type;
    this.name = name;
    this.size = size;
    this.text = text;
    this.src = src;
    this.isOrder = isOrder;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getIsOrder() {
    return isOrder;
  }

  public void setIsOrder(String isOrder) {
    this.isOrder = isOrder;
  }
}
