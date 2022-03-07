package com.onetomany.jpa2.controller;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.jpa2.model.CommentDto;
import com.onetomany.jpa2.model.TutorialDto;
import com.onetomany.jpa2.repository.TutorialRepository;
import com.onetomany.jpa2.services.TutorialServices;


@RestController
public class TutorialController {
	
	@Autowired
	TutorialServices tutorialService;
	
	@PostMapping(path="/tutorials")
	public ResponseEntity<?> saveTutorial(@RequestBody TutorialDto tutorialDto){
		tutorialService.saveTutorial(tutorialDto);
		return ResponseEntity.ok("Tutorial added.");
	}
	
	@GetMapping(path="/tutorials/{tutorialId}")
	public ResponseEntity<?> getTutorial(@PathVariable("tutorialId") BigInteger tutorialId){
		TutorialDto tutorialDto = tutorialService.getTutorial(tutorialId);
		return ResponseEntity.ok(tutorialDto);
		
	}
	
	@PutMapping(path="/tutorials/{tutorialId}")
	public ResponseEntity<?> updateTutorial(@PathVariable("tutorialId") BigInteger tutorialId, @RequestBody TutorialDto tutorialDto){
		tutorialService.updateTutorial(tutorialId, tutorialDto);
		return ResponseEntity.ok("Tutorial is updated");
	}
	
//	@PatchMapping(path="/tutorials/{tutorialId}")
//	public ResponseEntity<?> patchPublished(@PathVariable ("tutorialId") BigInteger tutorialId, @RequestBody Map<Boolean, Boolean> published){
//		
//		return ResponseEntity.ok("Tutorial is updated");
//	}
	
	
	/* ****************COMMENT SECTION STARTS HERE **************************** */ 
	@PostMapping(path = "/tutorials/{tutorialId}/comments")
	public ResponseEntity<?> postComment(@PathVariable(value = "tutorialId") BigInteger tutorialId,
			@RequestBody CommentDto commentDTO) {
		tutorialService.postComment(tutorialId, commentDTO);
		return ResponseEntity.ok("Comment Added");

	}
	
	@PutMapping(path = "/tutorials/{tutorialId}/comments/{commentId}")
	public ResponseEntity<?> getCommentByID(@PathVariable(value = "tutorialId") BigInteger tutorialId,
			@PathVariable(value = "commentId") BigInteger commentId, @RequestBody CommentDto commentDto){
			tutorialService.putComment(commentId, commentDto);

			return ResponseEntity.ok("Comment updated");
		
	}
}
