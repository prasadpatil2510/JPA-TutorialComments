package com.onetomany.jpa2.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Comment {
	
	@Id 
	@SequenceGenerator(name = "tutorial_id_seq", sequenceName = "tutorial_id_seq", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_id_seq") 
	private BigInteger id; 
	private String content; 

	@ManyToOne 
	@JoinColumn(name = "tutorial_id") 
	private Tutorial tutorial; 
}
