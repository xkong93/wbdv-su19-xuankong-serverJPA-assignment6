package com.example.wbdvsu19xuankongmyappassignment6.services;

import com.example.wbdvsu19xuankongmyappassignment6.models.Topic;
import com.example.wbdvsu19xuankongmyappassignment6.models.Widget;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.TopicRepository;
import com.example.wbdvsu19xuankongmyappassignment6.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xuan Kong
 * @Date 2019-06-11.
 */
@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

  @Autowired
  TopicRepository topicRepository;

  public List<Widget> addWidgetToTopic(Long tid, Widget newWidget) {
    Topic topic = topicRepository.findById(tid).get();
    newWidget.setTopic(topic);
    repository.save(newWidget);
    return findAllWidgetForTopic(tid);
  }

 public List<Widget> findAllWidgetForTopic(Long tid) {
    Topic topic = topicRepository.findById(tid).get();
    return topic.getWidgets();
  }

  public List<Widget> findAllWigets() {
    return (List<Widget>) repository.findAll();
  }

  public Widget findWidgetById(Long wid) {
    return repository.findById(wid).get();
  }

  public Widget updateWidget(Long wid, Widget newWidget) {
    Widget widget = repository.findById(wid).get();
    widget.setType(newWidget.getType());
    widget.setName(newWidget.getName());
    widget.setSize(newWidget.getSize());
    widget.setText(newWidget.getText());
    widget.setSrc(newWidget.getSrc());
    widget.setIsOrder(newWidget.getIsOrder());
    repository.save(widget);
    return widget;
  }

  public void deleteWidget(Long wid) {
    repository.deleteById(wid);
  }
}
