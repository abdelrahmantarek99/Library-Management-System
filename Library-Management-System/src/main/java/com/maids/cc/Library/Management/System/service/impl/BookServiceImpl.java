package com.maids.cc.Library.Management.System.service.impl;

import com.maids.cc.Library.Management.System.Exception.NotFound;
import com.maids.cc.Library.Management.System.dao.BookDAO;
import com.maids.cc.Library.Management.System.model.entity.Book;
import com.maids.cc.Library.Management.System.service.framework.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    final BookDAO bookDAO;

    @Override
    public List<Book> findBooks() throws Exception{
        return bookDAO.findAll();
    }

    @Override
    public Book findBook(int id) throws Exception{
        Optional<Book> book = bookDAO.findById(id);
        if(book.isPresent()) return book.get();
        else {
            throw new NotFound("book is not found");
        }
    }

    @Override
    public void insertBook(Book book) throws Exception{
        bookDAO.save(book);
    }

    @Override
    public void updateBook(int id, Book book) throws Exception{
        if(bookDAO.existsById(id)) {
            book.setId(id);
            bookDAO.save(book);
        } else {
            throw new NotFound("book is not found");
        }
    }

    @Override
    public void deleteBook(int id) throws Exception{
        bookDAO.deleteById(id);
    }
}
