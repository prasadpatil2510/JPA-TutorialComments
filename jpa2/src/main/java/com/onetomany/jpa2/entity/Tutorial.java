package com.onetomany.jpa2.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tutorial")
public class Tutorial {

	@Id
	@SequenceGenerator(name = "tutorial_id_seq", sequenceName = "tutorial_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_id_seq")
	private BigInteger id;
	private String title;
	private String description;
	private Boolean published;
	
	@OneToMany(mappedBy="tutorial", cascade = CascadeType.ALL)	
	private List<Comment> comment;
	
}
