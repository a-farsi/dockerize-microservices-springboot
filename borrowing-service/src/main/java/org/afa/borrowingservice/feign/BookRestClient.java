package org.afa.borrowingservice.feign;

import org.afa.borrowingservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-service")
public interface BookRestClient {
	@GetMapping("/books/{id}")
	Book getBookById(@PathVariable Long id);

	@GetMapping("/books")
	List<Book> getAllBooks();
}