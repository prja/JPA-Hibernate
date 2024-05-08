package com.prja.h2demo.manytomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String bithDate;
	
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	private List<Skill> skillList;

	

	

}
