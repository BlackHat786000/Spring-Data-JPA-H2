package com.spring.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.datajpa.entity.ATM;
import com.spring.datajpa.entity.DebitCard;

@SpringBootTest
public class AtmRepositoryTest {
	
	@Autowired
	private AtmRepository repository;
	
	@Test
	public void saveAtmWithDebitCards() {
		ATM atm = ATM.builder()
				.Id(112)
				.bankName("DBS BANK")
				.address("rajendra nagar")
				.active(true)
				.build();
		
		DebitCard debitCard1 = DebitCard.builder()
				.cardNumber(2978249872389L)
				.cvv(325)
				.expiry("10/08/2024")
				.bankName("YES BANK")
				.build();
		DebitCard debitCard2 = DebitCard.builder()
				.cardNumber(1314122345346L)
				.cvv(523)
				.expiry("13/08/2029")
				.bankName("CENTRAL BANK")
				.build();
		
		atm.addDebitCard(debitCard1);
		atm.addDebitCard(debitCard2);
		
		repository.save(atm);
	}
	
}
