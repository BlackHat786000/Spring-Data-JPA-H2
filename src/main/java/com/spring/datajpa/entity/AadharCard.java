package com.spring.datajpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AadharCard {
	
	@Id
	private Long number;
	private String name;
	private String dob;
	private String gender;
	
	@OneToOne(mappedBy = "aadharCard")
	private User user;

}
