package com.spring.datajpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="atm_table")
public class ATM {
	
	private Integer Id;
	@Id
	private String bankName;
	private String address;
	private Boolean active;
	
	@ManyToMany(
			cascade=CascadeType.ALL
	)
	@JoinTable(
			name = "debitcard_atm_map",
			joinColumns = @JoinColumn(
					name = "atm_bank_name",
					referencedColumnName = "bankName"
			),
			inverseJoinColumns = @JoinColumn(
					name = "debit_card_no",
					referencedColumnName = "cardNumber"
			)
	)
	private List<DebitCard> debitCards;
	
	public void addDebitCard(DebitCard debitCard) {
		if(debitCards == null) {
			debitCards = new ArrayList<>();
		}
		debitCards.add(debitCard);
	}
	
}
