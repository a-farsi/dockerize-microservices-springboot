package org.afa.borrowingservice.web;

import org.afa.borrowingservice.entities.Borrow;
import org.afa.borrowingservice.feign.BookRestClient;
import org.afa.borrowingservice.feign.CustomerRestClient;
import org.afa.borrowingservice.repository.BorrowRepository;
import org.afa.borrowingservice.repository.BorrowedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class BorrowRestController {
	@Autowired
	private BorrowRepository borrowRepository;
	@Autowired
	private BorrowedBookRepository borrowedBookRepository;
	@Autowired
	private CustomerRestClient customerRestClient;
	@Autowired
	private BookRestClient bookRestClient;

	@GetMapping(path = "/api/borrows/{id}")
	public Borrow getBorrowById(@PathVariable Long id) {

		Borrow borrow = borrowRepository.findById(id).orElse(null);
		if(!Objects.isNull(borrow) && !Objects.isNull(borrow.getCustomerId()))
			borrow.setCustomer(customerRestClient.getCustomerById(borrow.getCustomerId()));
		Objects.requireNonNull(borrow).getBorrowedBooks().forEach(borrowedBook ->
				borrowedBook.setBook(bookRestClient.getBookById(borrowedBook.getBookId())));

		return borrow;

	}

	@GetMapping(path = "/borrows")
	public List<Borrow> getAllBorrows() {
		return borrowRepository.findAll();
	}
}
