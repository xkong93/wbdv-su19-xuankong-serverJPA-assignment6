package com.example.wbdvsu19xuankongmyappassignment6.repositories;

import com.example.wbdvsu19xuankongmyappassignment6.models.Lesson;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Xuan Kong
 * @Date 2019-06-19.
 */
@Repository
public interface LessonRepository extends CrudRepository<Lesson,Long> {


}
