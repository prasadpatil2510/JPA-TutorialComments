package com.onetomany.jpa2.model;

import java.util.List;

import com.onetomany.jpa2.entity.Comment;

import lombok.Data;

@Data
public class TutorialDto {
	
	private String title;
	private String description;
	private Boolean published;
	private List<Comment> comments;
}
