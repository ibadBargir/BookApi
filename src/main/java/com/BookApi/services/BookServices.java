package com.BookApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookApi.Repository.BookRepository;
import com.BookApi.entites.Book;

@Service
public class BookServices {

	@Autowired
	private BookRepository bookRepository;

	// Method to get all books from the repository
	public List<Book> getALLBooks() {
		return (List<Book>) this.bookRepository.findAll();// Fetch all books from the database
	}

	// Example method to add a book (you need to implement the details)
	 public Book getBookById(int id) {
		 Book book =null;
		 try {
	      book= this.bookRepository.findById(id);
		 }catch(Exception e){ 
			 e.printStackTrace();
	    }
		 return book;
	 }
	// add book using postmethod
//	public Book addBook(Book b) {
//
//	Book result =bookRepository.save(b);
//		return result;
//	}
	  public Book addBook(Book book) {
	        return bookRepository.save(book);
	    }
	
	//delete 
	
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
		
	}

	//putmethod
//	public void updateBook(Book book , int bookId) {
//		
//		book.setId(bookId);
//		bookRepository.save(bookId);
//	}
	
	 public Book updateBook(Book book, int bookId) {
	        if (bookRepository.existsById(bookId)) {
	            book.setId(bookId);
	            return bookRepository.save(book);
	        } else {
	            return null; // Indicate that the book was not found
	        }
	    }

}
