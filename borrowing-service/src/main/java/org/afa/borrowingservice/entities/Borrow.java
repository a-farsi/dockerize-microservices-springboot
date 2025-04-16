package org.afa.borrowingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.afa.borrowingservice.model.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long customerId;
	@Transient
	Customer customer;
	private LocalDateTime startBorrowingDate;
	private LocalDateTime returnDate;
	@OneToMany(mappedBy = "borrow", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BorrowedBook> borrowedBooks = new ArrayList<>();
}