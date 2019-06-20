package com.example.wbdvsu19xuankongmyappassignment6.repositories;

import com.example.wbdvsu19xuankongmyappassignment6.models.Module;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-18.
 */
@Repository
public interface ModuleRepository extends CrudRepository<Module, Long> {


  //in SQL syntax
  // select module from Module m, Course c where m.course_id = c.id
  // JPQL below
//  @Query("select module from Module module where module.course.id = :cid")
//  public List<Module> findAllModulesForCourse(@Param("cid") Integer courseId);

}



