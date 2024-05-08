package com.prja.h2demo.manytomany_self;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity

public class People {
	
	@Id
	@Column(name="PEOPLE_ID")
	@GeneratedValue
	private Long PERSONId;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="PEOPLE_FREIND",
		joinColumns={@JoinColumn(name="PEOPLE_ID")},
		inverseJoinColumns={@JoinColumn(name="FREIND_ID")})
	private Set<People> freinds = new HashSet<People>();

	@ManyToMany(mappedBy="freinds")
	private Set<People> freindsOf = new HashSet<People>();

	public People() {
	}

	public People(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<People> getFreinds() {
		return freinds;
	}

	public void setFreinds(Set<People> freinds) {
		this.freinds = freinds;
	}

	public Set<People> getFreindsOf() {
		return freindsOf;
	}

	public void setFreindsOf(Set<People> freindsOf) {
		this.freindsOf = freindsOf;
	}

	@Override
	public String toString() {
		return "Person [PERSONId=" + PERSONId + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
		
}