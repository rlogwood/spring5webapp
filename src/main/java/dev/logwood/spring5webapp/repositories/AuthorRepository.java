package dev.logwood.spring5webapp.repositories;

import dev.logwood.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
