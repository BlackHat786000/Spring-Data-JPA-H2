package com.spring.datajpa.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.datajpa.entity.DebitCard;
import com.spring.datajpa.entity.User;

@SpringBootTest
public class DebitCardRepositoryTest {
	
	@Autowired
	private DebitCardRepository repository;
	
	@Test
	public void saveDebitCardWithUser() {
		User user = User.builder()
				.name("umesh yadav")
				.age(32)
				.email("viraj_yadav@gmail.com")
				.build();
		
		DebitCard debitCard = DebitCard.builder()
				.cardNumber(2387494589690L)
				.cvv(675)
				.expiry("06/08/2027")
				.bankName("Kotak mahindra bank")
				.user(user)
				.build();
		
		repository.save(debitCard);
	}
	
	@Test
	public void findDebitCardById() {
		Optional<DebitCard> debitCard = repository.findById(2387494589690L);
		System.out.println("debit card - "+debitCard.get());
	}

}
