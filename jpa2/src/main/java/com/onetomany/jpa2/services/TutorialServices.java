package com.onetomany.jpa2.services;

import java.math.BigInteger;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.jpa2.entity.Comment;
import com.onetomany.jpa2.entity.Tutorial;
import com.onetomany.jpa2.mapper.CommentMapper;
import com.onetomany.jpa2.mapper.TutorialMapper;
import com.onetomany.jpa2.model.CommentDto;
import com.onetomany.jpa2.model.TutorialDto;
import com.onetomany.jpa2.repository.CommentRepository;
import com.onetomany.jpa2.repository.TutorialRepository;

@Service
public class TutorialServices {
	

	private final TutorialRepository tutorialRepository;
	private final TutorialMapper tutorialMapper;
	private final CommentRepository commentRepository;
	private final CommentMapper commentMapper;
	
	
	@Autowired
	public TutorialServices(TutorialRepository tutorialRepository, TutorialMapper tutorialMapper,
			CommentRepository commentRepository, CommentMapper commentMapper) {
		super();
		this.tutorialRepository = tutorialRepository;
		this.tutorialMapper = tutorialMapper;
		this.commentRepository = commentRepository;
		this.commentMapper = commentMapper;
	}

	public void saveTutorial(TutorialDto tutorialDto) {
		// TODO Auto-generated method stub
		Tutorial tutorial = tutorialMapper.toEntity(tutorialDto);
		tutorialRepository.save(tutorial);
	}
	
	public TutorialDto getTutorial(BigInteger tutorialId) {
		Optional<Tutorial> optionalTutorial = tutorialRepository.findById(tutorialId);
		Tutorial tutorial = optionalTutorial.get();
		return tutorialMapper.toDto(tutorial);
	}

	public void updateTutorial(BigInteger tutorialId, TutorialDto tutorialDto) {
		Optional<Tutorial> optionalTutorialEntity = tutorialRepository.findById(tutorialId);
		if(optionalTutorialEntity.isPresent()) {
			tutorialMapper.updateTutorial(tutorialDto, optionalTutorialEntity.get());
			tutorialRepository.save(optionalTutorialEntity.get());
		}else {
			System.out.print("Tutorial Not Found");
		}
	}
	
	public void postComment(BigInteger tutorialId, CommentDto commentDto) {
		Optional<Tutorial> tutorialOptional = tutorialRepository.findById(tutorialId);
		//Tutorial tutorial = tutorialOptional.get();
		Comment comment = commentMapper.toEntity(commentDto);
		comment.setTutorial(tutorialOptional.get());
		commentRepository.save(comment);
		System.out.print("Comment for comment id" +comment.getId()+"to the tutorial "+ tutorialId + "updated successfully");
	}
	
	public void putComment(BigInteger BigInteger commentId, CommentDto commentDto ) {
		Optional<Comment> commentOptional = commentRepository.findById(commentId);
		Comment comment = commentMapper.toEntity(commentDto);
		commentRepository.save(comment);
		System.out.println("Comment updated");
	}
	
}
