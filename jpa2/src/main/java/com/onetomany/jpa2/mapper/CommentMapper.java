package com.onetomany.jpa2.mapper;

import org.mapstruct.Mapper;

import com.onetomany.jpa2.entity.Comment;
import com.onetomany.jpa2.model.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {

	Comment toEntity(CommentDto commentDto);
	CommentDto toDto(Comment comment);
	
	
}
