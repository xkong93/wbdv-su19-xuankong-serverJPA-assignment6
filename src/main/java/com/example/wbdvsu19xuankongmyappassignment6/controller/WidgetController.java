package com.example.wbdvsu19xuankongmyappassignment6.controller;

import com.example.wbdvsu19xuankongmyappassignment6.models.Widget;
import com.example.wbdvsu19xuankongmyappassignment6.services.WidgetService;

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
 * @Date 2019-06-11.
 */


@RestController
@CrossOrigin("*")
public class WidgetController {

  @Autowired
  WidgetService widgetService;


  @PostMapping("/api/topic/{tid}/widget")
  public List<Widget> createWidget(
          @PathVariable("tid") Long tid,
          @RequestBody Widget widget) {
    widgetService.addWidgetToTopic(tid,widget);
    return widgetService.findAllWidgetForTopic(tid);
  }

  @GetMapping("/api/topic/{tid}/widget")
  public List<Widget> findAllWigets(@PathVariable("tid") Long tid) {
    return widgetService.findAllWidgetForTopic(tid);
  }


  @GetMapping("/api/widget/{wid}")
  public Widget findWidgetById(@PathVariable("wid") Long wid) {
    return widgetService.findWidgetById(wid);
  }

  @PutMapping("/api/widget/{wid}")
  public Widget updateWidget(
          @PathVariable("wid") Long wid,
          @RequestBody Widget newWidget) {
    return widgetService.updateWidget(wid, newWidget);
  }

  @DeleteMapping("/api/widget/{wid}")
  public void deleteWidget(@PathVariable("wid") Long wid) {
    widgetService.deleteWidget(wid);
  }
}
