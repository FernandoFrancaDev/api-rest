package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Book;
import app.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public String save(Book book) {
		this.bookRepository.save(book);
		return "Book salvo com sucesso";
	}
	public String update(Book book, long id) {
		book.setId(id);
		this.bookRepository.save(book);
		return "Book salvo com sucesso";
	}
	public String delete(long id) {
		this.bookRepository.deleteById(id);
		return "Book salvo com sucesso";
	}
	public List<Book> findAll(){
		List<Book> lista = this.bookRepository.findAll();
		return lista;
	}
	public Book findById(long id) {
		Book book = this.bookRepository.findById(id).get();
		return book;
	}

}
