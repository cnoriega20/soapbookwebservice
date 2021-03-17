package com.springboot.soap.example.repositories;

import com.springboot.soap.example.domain.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
