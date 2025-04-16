package org.afa.bookservice.dao;

import org.afa.bookservice.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
