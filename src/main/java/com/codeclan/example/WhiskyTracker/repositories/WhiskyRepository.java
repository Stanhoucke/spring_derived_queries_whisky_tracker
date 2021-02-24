package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    // get all whisky for a particular year
    List<Whisky> findWhiskyByYear(int year);

    // Get all the whisky from a particular distillery that's a specific age
    List<Whisky> findWhiskyByAgeAndDistillery(int age, Distillery distillery);

}
