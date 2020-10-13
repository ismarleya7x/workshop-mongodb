package com.ismarleycarvalho.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ismarleycarvalho.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
}