package com.spring.datajpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebitCard {
	
	@Id
	private Long cardNumber;
	private String bankName;
	private Integer cvv;
	private String expiry;
	
	@ManyToOne(
			cascade=CascadeType.ALL
	)
	@JoinColumn(
			name="user_id",
			referencedColumnName="userId"
	)
	private User user;

}
