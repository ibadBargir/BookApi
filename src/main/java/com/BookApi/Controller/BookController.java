package com.BookApi.Controller;

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

import com.BookApi.entites.Book;
import com.BookApi.services.BookServices;

@RestController
public class BookController {

	@Autowired
	private BookServices bookServices;

	// get all books
	@GetMapping("/books")
	public List<Book> getBooks() {

		return this.bookServices.getALLBooks();
	}

	// get Single book by id
	@GetMapping("books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookServices.getBookById(id);
		if (book == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(book));
	}

	// add a book post mapping
//	@PostMapping("/books")
//	public ResponseEntity<Book> addBook(@RequestBody Book book) {
//		Book b = null;
//
//		 try {
//			 b = this.bookServices.addBook(book);
//				System.out.println(book);
//				return ResponseEntity.of(Optional.of(b));
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//		
		
	 @PostMapping("/books")
	    public ResponseEntity<Book> addBook(@RequestBody Book book) {
	        try {
	            Book createdBook = bookServices.addBook(book);
	            return ResponseEntity.ok(createdBook);
	        } catch (Exception e) {
	            e.printStackTrace(); // Consider using a logger instead
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    

	}

	// delete book method is delete
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {

		this.bookServices.deleteBook(bookId);

	}

	// Update Book using putMapping

//	@PutMapping("/books/{bookId}")
//	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
//		try {
//			this.bookServices.updateBook(book, bookId);
//			return ResponseEntity.ok().body(book);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//
//	}
	
	 @PutMapping("/books/{bookId}")
	    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
	        try {
	            Book updatedBook = bookServices.updateBook(book, bookId);
	            if (updatedBook != null) {
	                return ResponseEntity.ok(updatedBook);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); // Consider using a logger instead
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

}
