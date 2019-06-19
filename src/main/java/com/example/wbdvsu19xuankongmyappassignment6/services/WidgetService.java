package com.example.wbdvsu19xuankongmyappassignment6.services;

import com.example.wbdvsu19xuankongmyappassignment6.models.Widget;
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

  public List<Widget> createWidget(Widget widget) {
    repository.save(widget);
    return findAllWigets();
  }


  public List<Widget> findAllWigets() {
    return (List<Widget>) repository.findAll();
  }


  public Widget findWidgetById(Long id) {
    Widget widget = repository.findById(id).get();
    return widget;
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
