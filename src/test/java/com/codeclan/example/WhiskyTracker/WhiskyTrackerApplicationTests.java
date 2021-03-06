package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByAgeAndDistillery(){
		Distillery foundDistillery = distilleryRepository.getOne(1L);
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByAgeAndDistillery(15, foundDistillery);
		assertEquals("The Glendronach Revival", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindWhiskyByDistilleryRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryRegion("Highland");
		assertEquals(7, foundWhiskies.size());
	}

	@Test
	public void canFindDistilleriesWith12YearOldWhiskies(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByWhiskiesAge(12);
		assertEquals(6, foundDistilleries.size());
	}

}
