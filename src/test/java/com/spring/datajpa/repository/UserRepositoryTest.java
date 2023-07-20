package com.spring.datajpa.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spring.datajpa.entity.AadharCard;
import com.spring.datajpa.entity.Guardian;
import com.spring.datajpa.entity.User;

@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	public UserRepository userRepository;
	
	@Test
	public void saveUser() {
		Guardian guardian = Guardian.builder()
				.name("ramesh")
				.age(75)
				.email("ramesh@gmail.com")
				.mobileNo("7999977778")
				.build();
		
		User user = User.builder()
				.name("suresh")
				.age(28)
				.email("suresh@gmail.com")
				.guardian(guardian)
				.build();
		
		userRepository.save(user);
	}
	
	@Test
	public void findByUserId() {
		// inbuilt method - doesn't matter what's the name of entity id field
		Optional<User> user = userRepository.findById(7L);
		System.out.println("USER = "+user.get());
	}
	
	@Test
	public void findByUserIdCustom() {
		// custom method - by the name of entity id field
		User user = userRepository.findByUserId(1L);
		System.out.println("USER = "+user);
	}
	
	@Test
	public void findByAge() {
		// use list when fetching with non-unique fields
		List<User> userList = userRepository.findByAge(28);
		System.out.println("USER = "+userList);
	}
	
	@Test
	public void findByEmail() {
		User user = userRepository.findByEmail("manish@gmail.com");
		System.out.println("USER = "+user);
	}
	
	@Test
	public void getNameUsingAge() {
		List<String> usernames = userRepository.getNameUsingAge(28);
		System.out.println("USER NAMES = "+usernames);
	}
	
	@Test
	public void getUserUsingEmailNative() {
		User user = userRepository.getUserUsingEmailNative("manish@gmail.com");
		System.out.println("USER = "+user);
	}
	
	@Test
	public void getUserUsingEmailNamedParam() {
		User user = userRepository.getUserUsingEmailNamedParam("yadavudit786@gmail.com");
		System.out.println("USER = "+user);
	}
	
	@Test
	public void updateEmailByName() {
		userRepository.updateEmailByName("manish786@gmail.com", "manish");
	}
	
	@Test
	public void saveUserWithAadhar() {
		Guardian guardian = Guardian.builder()
				.name("usha yadav")
				.age(50)
				.email("ushayadav@gmail.com")
				.mobileNo("701132123")
				.build();
		
		AadharCard aadharCard = AadharCard.builder()
				.number(466556766879L)
				.name("Indrajeet Yadav")
				.dob("1 June 1998")
				.gender("Male")
				.build();
		
		User user = User.builder()
				.name("Indra")
				.age(27)
				.email("udityadav787@gmail.com")
				.guardian(guardian)
				.aadharCard(aadharCard)
				.build();
		
		userRepository.save(user);
	}
	
	@Test
	public void saveUserWithDebitCards() {
//		DebitCard axisCard = DebitCard.builder()
//				.cardNumber(284574597834978L)
//				.bankName("AXIS BANK")
//				.cvv(323)
//				.expiry("03/09/2023")
//				.build();
//		DebitCard hdfcCard = DebitCard.builder()
//				.cardNumber(2937847894978L)
//				.bankName("HDFC BANK")
//				.cvv(565)
//				.expiry("06/08/2024")
//				.build();
		
		AadharCard aadharCard = AadharCard.builder()
				.number(212535475678L)
				.name("Jamuna Yadav")
				.dob("1 June 1930")
				.gender("Male")
				.build();
		
		User user = User.builder()
				.name("Jamuna das")
				.age(93)
				.email("NA")
				.aadharCard(aadharCard)
//				.debitCards(List.of(axisCard, hdfcCard))
				.build();
		
		userRepository.save(user);
	}
	
	@Test
	public void findAllPagination() {
		// pages start with 0
		Pageable secondPageThreeRecords = PageRequest.of(1, 3);
		List<User> users = userRepository.findAll(secondPageThreeRecords).getContent();
		long totalElements = userRepository.findAll(secondPageThreeRecords).getTotalElements();
		long totalPages = userRepository.findAll(secondPageThreeRecords).getTotalPages();
		System.out.println("2nd page 3 records => "+users);
		System.out.println("total elements: "+totalElements);
		System.out.println("total pages: "+totalPages);
	}
	
	@Test
	public void findByEmailContainingPagination() {
		Pageable firstPageThreeRecords = PageRequest.of(0, 3);
		List<User> users = userRepository.findByEmailContaining("mo", firstPageThreeRecords).getContent();
		System.out.println("users containing 'mo' in there email on first page of 3 records: "+users);
	}
	
	@Test
	public void findAllSorting() {
//		Pageable sortByName = PageRequest.of(1, 3, Sort.by("name"));
		
		Pageable sortByNameDesc = PageRequest.of(1, 3, Sort.by("name").descending());
		
//		The data will be sorted primarily by "age" in descending order, and for items with the same "age," it will further sort them by "name" in descending order.
//		Pageable sortByAgeDescAndNameDesc = PageRequest.of(1, 3, Sort.by("age").descending().and(Sort.by("name").descending()));
		
		List<User> users = userRepository.findAll(sortByNameDesc).getContent();
		System.out.println("usernames sorted in dsc order on second page of 3 records: "+users);
	}

}
