package com.kartik.spring.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kartik.spring.model.User;
import com.kartik.spring.repository.UserRepository;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	UserRepository userRepo;

	@Override
	public void run(String... arg0) throws Exception {
		userRepo.save(new User("Kartik", "Admin"));
		userRepo.save(new User("Amar", "User"));
		userRepo.save(new User("Sakar", "User"));

		for (User user : userRepo.findAll()) {
			log.info(user.toString());
		}
		
		for (User user : userRepo.findByRole("Admin")) {
			log.info(user.toString());
		}
		
	}

}
