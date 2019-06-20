package com.example.wbdvsu19xuankongmyappassignment6.controller;

import com.example.wbdvsu19xuankongmyappassignment6.models.Lesson;
import com.example.wbdvsu19xuankongmyappassignment6.services.LessonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-19.
 */
public class LessonController {

  @Autowired
  LessonService service;


  @PostMapping("/api/modules/{mid}/lessons")
  public List<Lesson> createLesson(
    @PathVariable("mid") Long mid,
    @RequestBody Lesson newLesson){
    service.addLessonToModule(mid,newLesson);
    return findAllLessons(mid);
  }

  @GetMapping("/api/modules/{mid}/lessons")
  public List<Lesson> findAllLessons(@PathVariable("mid") Long mid){
    return service.findAllLessonForModule(mid);
  }

  @GetMapping("/api/lessons/{lid}")
  public Lesson findLessonById(@PathVariable("lid") Long lid){
    return service.findLessonById(lid);
  }

  @PutMapping("api/lessons/{lid}")
  public Lesson updateLesson(
    @PathVariable("lid") Long lid,
    @RequestBody Lesson lesson){

    return service.updateLesson(lid,lesson);
  }

  @DeleteMapping("/api/lessons/{lid}")
  public void deleteLesson(@PathVariable("lid") Long lid){
    service.deleteLesson(lid);
  }

}
