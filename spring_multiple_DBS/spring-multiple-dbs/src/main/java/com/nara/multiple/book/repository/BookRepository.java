package com.nara.multiple.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nara.multiple.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
