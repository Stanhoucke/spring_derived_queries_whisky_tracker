package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    // get all distilleries for a particular region
    List<Distillery> findDistilleryByRegion(String region);

    // Get distilleries that have whiskies that are 12 years old
    List<Distillery> findDistilleryByWhiskiesAge(int age);

}
