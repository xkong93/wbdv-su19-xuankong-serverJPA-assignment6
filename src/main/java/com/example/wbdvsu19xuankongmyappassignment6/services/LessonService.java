package com.example.wbdvsu19xuankongmyappassignment6.services;

import com.example.wbdvsu19xuankongmyappassignment6.models.Lesson;
import com.example.wbdvsu19xuankongmyappassignment6.models.Module;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.LessonRepository;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-19.
 */

@Service
public class LessonService {


  @Autowired
  LessonRepository repository;

  @Autowired
  ModuleRepository moduleRepository;


  public List<Lesson> addLessonToModule(Long mid, Lesson newLesson) {
    Module module = moduleRepository.findById(mid).get();
    newLesson.setModule(module);
    repository.save(newLesson);
    return findAllLessonForModule(mid);
  }

  public List<Lesson> findAllLessonForModule(Long mid) {
    Module module = moduleRepository.findById(mid).get();
    return module.getLessons();
  }

  public List<Lesson> findAllLesson() {
    return (List<Lesson>) repository.findAll();
  }


  public Lesson findLessonById(Long lid){
    return repository.findById(lid).get();
  }

  public Lesson updateLesson(Long lid, Lesson lesson){
    Lesson updateModule = repository.findById(lid).get();
    updateModule.setTitle(lesson.getTitle());
    return updateModule;
  }

  public void deleteLesson(Long lid){
    repository.deleteById(lid);
  }

}
