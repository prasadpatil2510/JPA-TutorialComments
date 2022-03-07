package com.onetomany.jpa2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import com.onetomany.jpa2.entity.Tutorial;
import com.onetomany.jpa2.model.TutorialDto;

@Mapper(componentModel = "spring")
public interface TutorialMapper {
	TutorialDto toDto(Tutorial tutorial);
	Tutorial toEntity(TutorialDto tutorial);
	
	void updateTutorial(TutorialDto tutorialDto, @MappingTarget Tutorial tutorial);
	void patchTutorial(TutorialDto tutorialDto, @MappingTarget Tutorial tutorial);
}
