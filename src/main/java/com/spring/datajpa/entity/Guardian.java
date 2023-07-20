package com.spring.datajpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
	@AttributeOverride(
			name="name",
			column=@Column(name="guardian_name")
	),
	@AttributeOverride(
			name="age",
			column=@Column(name="guardian_age")
	),
	@AttributeOverride(
			name="email",
			column=@Column(name="guardian_email")
	),
	@AttributeOverride(
			name="mobileNo",
			column=@Column(name="guardian_mobile")
	)
})
public class Guardian {
	
	private String name;
	private Integer age;
	private String email;
	private String mobileNo;

}
