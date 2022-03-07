package com.onetomany.jpa2.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.jpa2.entity.Comment;



@Repository
public interface CommentRepository extends CrudRepository<Comment, BigInteger>{

}
