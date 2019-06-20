package com.example.wbdvsu19xuankongmyappassignment6.services;

import com.example.wbdvsu19xuankongmyappassignment6.models.Lesson;
import com.example.wbdvsu19xuankongmyappassignment6.models.Topic;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.LessonRepository;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-19.
 */
@Service
public class TopicService {


  @Autowired
  TopicRepository repository;

  @Autowired
  LessonRepository lessonRepository;


  public List<Topic> addTopicToLesson(Long lid, Topic newTopic) {
    Lesson lesson = lessonRepository.findById(lid).get();
    newTopic.setLesson(lesson);
    repository.save(newTopic);
    return findAllTopicForLesson(lid);
  }

  public List<Topic> findAllTopicForLesson(Long lid) {
    Lesson lesson = lessonRepository.findById(lid).get();
    return lesson.getTopics();
  }

  public List<Topic> findAllTopic() {
    return (List<Topic>) repository.findAll();
  }


  public Topic findTopicById(Long tid) {
    return repository.findById(tid).get();
  }

  public Topic updateTopic(Long tid, Topic lesson) {
    Topic updateTopic = repository.findById(tid).get();
    updateTopic.setTitle(lesson.getTitle());
    return updateTopic;
  }

  public void deleteTopic(Long tid) {
    repository.deleteById(tid);
  }

}
