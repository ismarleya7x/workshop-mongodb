package com.ismarleycarvalho.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismarleycarvalho.workshopmongodb.domain.Post;
import com.ismarleycarvalho.workshopmongodb.repository.PostRepository;
import com.ismarleycarvalho.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado!"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
