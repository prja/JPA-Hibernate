package com.prja.h2demo.inheriance.table_per_class;

import jakarta.persistence.Entity;

@Entity
public class Tomato extends Vegitable {

	private String color;

	private String taste;

	private String localName;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", taste=" + taste + ", localName=" + localName + ", getName()=" + getName()
				+ "]";
	}
}
