package org.afa.borrowingservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.afa.borrowingservice.model.Book;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowedBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long bookId;
	private String publisher;
	private String publishedDate;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Borrow borrow;
	@Transient
	private Book book;
}