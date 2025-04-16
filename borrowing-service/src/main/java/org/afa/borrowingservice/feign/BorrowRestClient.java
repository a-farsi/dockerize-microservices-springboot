package org.afa.borrowingservice.feign;

import org.afa.borrowingservice.entities.Borrow;
import org.afa.borrowingservice.entities.BorrowedBook;
import org.afa.borrowingservice.exception.ResourceNotFoundException;
import org.afa.borrowingservice.model.Book;
import org.afa.borrowingservice.model.Customer;
import org.afa.borrowingservice.repository.BorrowRepository;
import org.afa.borrowingservice.repository.BorrowedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class BorrowRestClient {

	@Autowired
	private BorrowRepository borrowRepository;
	@Autowired
	private BorrowedBookRepository borrowedBook;
	@Autowired
	private CustomerRestClient customerRestClient;

	@Autowired
	private BookRestClient bookRestClient;

	@GetMapping(path = "/borrows/{id}")
	public ResponseEntity<Borrow> getBorrow(@PathVariable Long id) {
		Borrow borrow = borrowRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Borrow not found with id: " + id));

		Customer customer = customerRestClient.getCustomerById(borrow.getCustomerId());
		if (Objects.isNull(customer)) {
			throw new ResourceNotFoundException("Customer not found with id: " + borrow.getCustomerId());
		}
		borrow.setCustomer(customer);

		borrow.getBorrowedBooks().forEach(borrowedBook -> {
			Book book = bookRestClient.getBookById(borrowedBook.getBookId());
			if (Objects.isNull(book)) {
				throw new ResourceNotFoundException("Book not found with id: " + borrowedBook.getBookId());
			}
			borrowedBook.setBook(book);
		});

		return ResponseEntity.ok(borrow);
	}

}
