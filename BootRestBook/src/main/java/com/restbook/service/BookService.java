package com.restbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restbook.model.Book;
import com.restbook.repository.BookRepository;
@Service
public class BookService {
	@Autowired
	private BookRepository bookrepository;
	
//	private static List<Book> list=new ArrayList<>();
//	static {
//		list.add(new Book(12,"Core Java","XyZ"));
//		list.add(new Book(37,"Advance Java","Xxx"));
//		list.add(new Book(123,"Spring Framework","XyX"));
//	}
	
	//get all Books
	public List<Book> getAllBooks(){
	    List<Book> list=this.bookrepository.findAll();
		return list;
	}
	
	//get single Book by id
	public Optional<Book> getBookById(int id) {
		
		Optional<Book> book=null;
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
		//return book;
		book=bookrepository.findById(id);
		return book;
		
	}
	//adding the new book
	public Book addBook(Book book) {
		//list.add(book);
		Book result=bookrepository.save(book);
		return result;
	}
	//delete a book by id
	public void deleteBook(int bid) {
//		list=list.stream().filter(book->{
//			if(book.getId()!=bid) {
//				return true;
//			}else {
//				return false;
//			}
//		}).collect(Collectors.toList());
	//list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
	    bookrepository.deleteById(bid);
	}
	
	//update the book
	public void updateBook(Book book,int bookId) {
//		list=list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());

		book.setId(bookId);
		bookrepository.save(book);
	}
}
