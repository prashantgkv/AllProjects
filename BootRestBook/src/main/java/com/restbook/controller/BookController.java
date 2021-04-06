package com.restbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restbook.model.Book;
import com.restbook.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
		
		List<Book> list=bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

//	public List<Book> getBooks() {
//		
//		return this.bookService.getAllBooks();
//	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Optional<Book>> getBook(@PathVariable("id") int id) {

		Optional<Book> book= bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
//	public Book getBook(@PathVariable("id") int id) {
//
//		Optional<Book> book= bookService.getBookById(id);
//		return book.get();
//	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b=this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
					
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
//	public Book addBook(@RequestBody Book book) {
//		Book b = this.bookService.addBook(book);
//		return b;
//	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		
		try {
		this.bookService.deleteBook(bookId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	} catch(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
		
	}
//	public void deleteBook(@PathVariable("bookId") int bookId) {
//		this.bookService.deleteBook(bookId);
//	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){ 
		try {
		this.bookService.updateBook(book,bookId);
		return ResponseEntity.ok().body(book);
	} catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	

//	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
//		this.bookService.updateBook(book,bookId);
//		return book;
//	}
    }
}