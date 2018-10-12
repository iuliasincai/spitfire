package com.fitness.spitfire.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.spitfire.model.Activity;
import com.fitness.spitfire.repository.ActivityRepository;

@RestController
@RequestMapping("api/v1")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(value = "activities", method = RequestMethod.GET)
    public List<Activity> list() {
        return activityRepository.findAll();
    }

    @RequestMapping(value = "activities", method = RequestMethod.POST)
    public Activity create(@RequestBody Activity activity) {
        return activityRepository.saveAndFlush(activity);
    }

    @RequestMapping(value = "activities/{id}", method = RequestMethod.GET)
    public Activity get(@PathVariable Long id) {
        return activityRepository.getOne(id);
    }

    @RequestMapping(value = "activities/{id}", method = RequestMethod.PUT)
    public Activity update(@PathVariable Long id, @RequestBody Activity activity) {
        Activity existingActivity = activityRepository.getOne(id);

        BeanUtils.copyProperties(activity, existingActivity);

        return activityRepository.saveAndFlush(existingActivity);
    }

    @RequestMapping(value = "activities/{id}", method = RequestMethod.DELETE)
    public Activity delete(@PathVariable Long id) {
        Activity existingActivity = activityRepository.getOne(id);

        activityRepository.delete(existingActivity);

        return existingActivity;
    }
}
