package org.afa.bookservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@JsonProperty("id")
	private Long id;

	private String title;
	private String author;
	private String isbn;
}
