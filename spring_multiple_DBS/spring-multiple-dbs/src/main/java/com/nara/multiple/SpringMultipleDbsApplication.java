package com.nara.multiple;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nara.multiple.book.repository.BookRepository;
import com.nara.multiple.model.book.Book;
import com.nara.multiple.model.user.User;
import com.nara.multiple.user.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
//@ComponentScan(basePackages = "{com.nara.multiple.*}")
public class SpringMultipleDbsApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@PostConstruct
	public void addData2DB() {
		userRepository.saveAll(Stream.of(new User(1L, "Narasimha"), new User(2L, "Priyanka")).toList());
		bookRepository.saveAll(Stream.of(new Book(1111L, "Core Java"), new Book(2222L, "Spring Boot")).toList());
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/allBooks")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringMultipleDbsApplication.class, args);
	}

}
