package org.afa.borrowingservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Book {
	private Long id;
	private String title;
	private String author;
	private String isbn;
}
