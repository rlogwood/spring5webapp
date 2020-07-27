package dev.logwood.spring5webapp.repositories;

import dev.logwood.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
