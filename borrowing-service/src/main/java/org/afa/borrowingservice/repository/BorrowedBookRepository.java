package org.afa.borrowingservice.repository;

import org.afa.borrowingservice.entities.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
