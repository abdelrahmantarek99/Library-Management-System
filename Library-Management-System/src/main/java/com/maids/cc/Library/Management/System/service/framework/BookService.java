package com.maids.cc.Library.Management.System.service.framework;

import com.maids.cc.Library.Management.System.model.entity.Book;

import java.util.List;


public interface BookService {
    List<Book> findBooks() throws Exception;///Retrieve a list of all books.
    Book findBook(int id) throws Exception;///Retrieve details of a specific book by ID.
    void insertBook(Book book) throws Exception;///Add a new book to the library.
    void updateBook(int id, Book book) throws Exception;///Update an existing book's information.
    void deleteBook(int id) throws Exception;///Remove a book from the library
}
