package com.spring.datajpa.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.datajpa.entity.AadharCard;

@SpringBootTest
public class AadharCardRepositoryTest {
	
	@Autowired
	private AadharCardRepository repository;
	
	@Test
	public void printAadharCard() {
		Optional<AadharCard> aadharCard = repository.findById(23834509409L);
		System.out.println("Aadhar card => "+aadharCard.get());
	}

}
