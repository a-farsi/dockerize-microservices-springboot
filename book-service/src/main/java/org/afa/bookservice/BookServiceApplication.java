package org.afa.bookservice;

import org.afa.bookservice.dao.BookRepository;
import org.afa.bookservice.entities.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BookRepository bookRepository){
		return args -> {
			Stream.of("Book1", "Book2", "Book3").forEach(bn -> {
				bookRepository.save(new Book(null,bn, "tauthor_"+bn, "isbn_"+100+Math.random()*900));
			});
			bookRepository.findAll().forEach(System.out::println);
		};
	}
}
