package org.afa.borrowingservice;

import org.afa.borrowingservice.entities.Borrow;
import org.afa.borrowingservice.entities.BorrowedBook;
import org.afa.borrowingservice.feign.BookRestClient;
import org.afa.borrowingservice.feign.CustomerRestClient;
import org.afa.borrowingservice.model.Book;
import org.afa.borrowingservice.model.Customer;
import org.afa.borrowingservice.repository.BorrowRepository;
import org.afa.borrowingservice.repository.BorrowedBookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BorrowingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowingServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BorrowRepository borrowRepository,
											   BorrowedBookRepository borrowedBookRepository,
											   CustomerRestClient customerRestClient,
											   BookRestClient bookRestClient) {

		return args -> {
			List<Customer> customers = customerRestClient.getAllCustomer();
			List<Book> books = bookRestClient.getAllBooks();

			customers.forEach(customer -> {
				Borrow borrow = Borrow.builder()
						.startBorrowingDate(LocalDateTime.now())
						.customerId(customer.getId())
						.build();
				borrowRepository.save(borrow);
				books.forEach(book -> {
					BorrowedBook borrowedBook = BorrowedBook.builder()
							.borrow(borrow)
							.bookId(book.getId())
							.publisher("first publisher")
							.publishedDate("2021-12-12")
							.build();
					borrowedBookRepository.save(borrowedBook);
				});
			});


			System.out.println("=================Display the saved objects===========================");
			borrowRepository.findAll().forEach(System.out::println);
			System.out.println("=====================================================================");
		};
	}
}
