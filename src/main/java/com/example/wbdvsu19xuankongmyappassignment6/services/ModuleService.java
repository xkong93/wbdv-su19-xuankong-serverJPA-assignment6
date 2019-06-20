package com.example.wbdvsu19xuankongmyappassignment6.services;

import com.example.wbdvsu19xuankongmyappassignment6.models.Course;
import com.example.wbdvsu19xuankongmyappassignment6.models.Module;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.CourseRepository;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-18.
 */

@Service
public class ModuleService {


  @Autowired
  ModuleRepository repository;

  @Autowired
  CourseRepository courseRepository;


  public List<Module> addModuleToCourse(Long cid, Module newModule) {
    Course course = courseRepository.findById(cid).get();
    newModule.setCourse(course); // now it has ref to the course it belongs to
    repository.save(newModule); // save it to the dbs
    return findAllModuleForCourse(cid);
  }

  public List<Module> findAllModuleForCourse(Long cid) {
    Course course = courseRepository.findById(cid).get();

    List<Module> modules = course.getModules();

    return modules;
  }

  public List<Module> findAllModules() {
    return (List<Module>) repository.findAll();
  }

  public Module findModuleById(Long mid) {
    return repository.findById(mid).get();
  }

  //Do i need to update the correspond course in the module ??
  public Module updateModule(Long mid, Module module){
    Module updateModule = repository.findById(mid).get();
    updateModule.setTitle(module.getTitle());
    return updateModule;
  }

  public void deleteModule(Long mid) {
    repository.deleteById(mid);
  }

}
