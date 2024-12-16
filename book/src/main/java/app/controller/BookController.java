package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Book;
import app.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Book book) {
		try {
		String mensagem = this.bookService.save(book);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {			
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Book book,@PathVariable long id) {
		try {
			String mensagem = this.bookService.update(book, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}			
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem =this.bookService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Book>> findAll(){
		try {
			List<Book> lista = this.bookService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Book> findById(@PathVariable long id) {
		try {
			Book book = this.bookService.findById(id);
			return new ResponseEntity<>(book, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

}
