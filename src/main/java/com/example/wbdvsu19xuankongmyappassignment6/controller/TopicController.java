package com.example.wbdvsu19xuankongmyappassignment6.controller;

import com.example.wbdvsu19xuankongmyappassignment6.models.Topic;
import com.example.wbdvsu19xuankongmyappassignment6.services.TopicService;

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
public class TopicController {

  @Autowired
  TopicService service;

  @PostMapping("/api/lesson/{lid}/topic")
  public List<Topic> createTopic(
    @PathVariable("lid") Long lid,
    @RequestBody Topic newTopic) {
    service.addTopicToLesson(lid, newTopic);
    return findAllTopics(lid);
  }

  @GetMapping("/api/lesson/{lid}/topic")
  public List<Topic> findAllTopics(@PathVariable("lid") Long lid) {
    return service.findAllTopicForLesson(lid);
  }

  @GetMapping("/api/topic/{tid}")
  public Topic findTopicById(@PathVariable("tid") Long tid) {
    return service.findTopicById(tid);
  }

  @PutMapping("api/topic/{tid}")
  public Topic updateTopic(
    @PathVariable("tid") Long tid,
    @RequestBody Topic topic) {

    return service.updateTopic(tid, topic);
  }

  @DeleteMapping("/api/topic/{tid}")
  public void deleteTopic(@PathVariable("tid") Long tid) {
    service.deleteTopic(tid);
  }

}
