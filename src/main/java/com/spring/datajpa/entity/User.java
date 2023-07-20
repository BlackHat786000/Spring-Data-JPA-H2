package com.spring.datajpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(exclude = "aadharCard")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
		name="user_table",
		uniqueConstraints=@UniqueConstraint(
				name="emailIdUnique",
				columnNames="emailId"
		)
)
public class User {
	
	@Id
	@SequenceGenerator(
			name="user_sequence",
			sequenceName="user_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="user_sequence"
	)
	private Long userId;
	private String name;
	private Integer age;
	@Column(
			name="emailId",
			nullable=false
	)
	private String email;
	
	@Embedded
	private Guardian guardian;
	
	@OneToOne(
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY
//			fetch=FetchType.EAGER
//			optional=false
	)
//	column "user_aadhar_no" will be created in user_table
	@JoinColumn(
			name="user_aadhar_no",
			referencedColumnName="number"
	)
	private AadharCard aadharCard;
	
//----------------------------- FOR ONE TO MANY & MANY TO ONE MAPPING -----------------------------------------------------
// new column (ONE primary key) always created in MANY and ONE primary key used in @JoinColumn
	
	
//	@OneToMany(
//			cascade=CascadeType.ALL
//	)
//	@JoinColumn(
//			name="user_id",
//			referencedColumnName="userId"
//	)
//	column "user_id" will be created in debit_card table, primary key of current class in "referencedColumnName"
//	private List<DebitCard> debitCards;

}
