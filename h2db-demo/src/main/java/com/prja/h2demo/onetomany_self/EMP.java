package com.prja.h2demo.onetomany_self;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EMP {
	@Id
	@Column(name="emp_id")
	@GeneratedValue
	private Long empID;
	
	private String firstname;
	
	private String lastname;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="manager_id")
	private EMP manager;

	@OneToMany(mappedBy="manager")
	private Set<EMP> teamMember = new HashSet<EMP>();

}
