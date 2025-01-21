package com.BookApi.Repository;

import com.BookApi.entites.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	
    // You can define custom query methods here if needed

	

	Book findById(int id);

	void save(int bookId);

	
}
