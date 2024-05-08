package com.prja.h2demo.inheriance.mapped_supper_class_annotation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Bus extends Vehical {

	@Column
	private String companyName;
	
	@Column
	private String registrationNo;
	@Column
	private boolean isCommercial;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public boolean isCommercial() {
		return isCommercial;
	}
	public void setCommercial(boolean isCommercial) {
		this.isCommercial = isCommercial;
	}
	
}
