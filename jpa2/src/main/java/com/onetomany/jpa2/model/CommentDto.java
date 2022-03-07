package com.onetomany.jpa2.model;

import com.onetomany.jpa2.entity.Tutorial;

import lombok.Data;

@Data
public class CommentDto {
	
	private String content;
	private TutorialDto tutorial;
}
