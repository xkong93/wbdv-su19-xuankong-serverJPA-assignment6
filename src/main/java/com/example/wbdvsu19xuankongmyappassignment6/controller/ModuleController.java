package com.example.wbdvsu19xuankongmyappassignment6.controller;

import com.example.wbdvsu19xuankongmyappassignment6.models.Module;
import com.example.wbdvsu19xuankongmyappassignment6.services.ModuleService;

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
 * @Date 2019-06-18.
 */
@RestController
@CrossOrigin("*")
public class ModuleController {

  @Autowired
  ModuleService service;

  @PostMapping("/api/course/{cid}/module")
  public List<Module> createModule(
          @PathVariable("cid") Long cid,
          @RequestBody Module newModule) {
    service.addModuleToCourse(cid, newModule);
    return findAllModulesForCourse(cid);
  }

  @GetMapping("/api/course/{cid}/module")
  public List<Module> findAllModulesForCourse(@PathVariable("cid") Long cid) {
    return service.findAllModuleForCourse(cid);
  }
  @GetMapping("/api/module")
  public List<Module> findAllModules() {
    return service.findAllModules();
  }

  @GetMapping("/api/module/{mid}")
  public Module findModuleById(@PathVariable("mid") Long mid) {
    return service.findModuleById(mid);
  }

  @PutMapping("/api/module/{mid}")
  public Module updateModule(
          @PathVariable("mid") Long mid,
          @RequestBody Module module) {
    return service.updateModule(mid, module);

  }

  @DeleteMapping("api/module/{mid}")
  public void deleteModule(@PathVariable("mid") Long mid) {
    service.deleteModule(mid);
  }


}
