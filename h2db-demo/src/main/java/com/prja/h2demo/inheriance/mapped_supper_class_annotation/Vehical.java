package com.prja.h2demo.inheriance.mapped_supper_class_annotation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

@MappedSuperclass
public  class Vehical {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String color;

	@Column
	private String noOfWheel;

	@Column
	private String type;

	// add if wish to not be part persistence
	@Transient
	private String localName;

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNoOfWheel() {
		return noOfWheel;
	}

	public void setNoOfWheel(String noOfWheel) {
		this.noOfWheel = noOfWheel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
