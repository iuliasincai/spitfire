package com.fitness.spitfire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.spitfire.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
