package com.ismarleycarvalho.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ismarleycarvalho.workshopmongodb.domain.Post;
import com.ismarleycarvalho.workshopmongodb.domain.User;
import com.ismarleycarvalho.workshopmongodb.dto.AuthorDTO;
import com.ismarleycarvalho.workshopmongodb.repository.PostRepository;
import com.ismarleycarvalho.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Valeu falou", new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Partiu Viagem 2", "Valeu falou 2",  new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(p1, p2));
		

	}

}
