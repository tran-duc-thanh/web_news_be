package com.ptit.web_news_be;

import com.ptit.web_news_be.auth.user.User;
import com.ptit.web_news_be.auth.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebNewsBeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebNewsBeApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// Khi chương trình chạy
		// Insert vào csdl một user.
		User user = new User();
		user.setUsername("loda");
		user.setPassword(passwordEncoder.encode("loda"));
		userRepository.save(user);
		System.out.println(user);
	}
}
