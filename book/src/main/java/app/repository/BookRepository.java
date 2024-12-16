package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
