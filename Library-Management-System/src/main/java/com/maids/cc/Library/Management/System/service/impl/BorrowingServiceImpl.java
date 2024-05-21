package com.maids.cc.Library.Management.System.service.impl;

import com.maids.cc.Library.Management.System.Exception.NotFound;
import com.maids.cc.Library.Management.System.dao.BorrowingDAO;
import com.maids.cc.Library.Management.System.model.api.request.InsertBorrowingRequest;
import com.maids.cc.Library.Management.System.model.dto.BorrowingCompositeKeyId;
import com.maids.cc.Library.Management.System.model.entity.Book;
import com.maids.cc.Library.Management.System.model.entity.Borrowing;
import com.maids.cc.Library.Management.System.model.entity.Patron;
import com.maids.cc.Library.Management.System.service.framework.BookService;
import com.maids.cc.Library.Management.System.service.framework.BorrowingService;
import com.maids.cc.Library.Management.System.service.framework.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLDataException;


@Service
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {
    final private BorrowingDAO borrowingDAO;
    final private BookService bookService;
    final private PatronService patronService;
    @Override
    public void insertBorrowingRecord(int bookId, int patronId, InsertBorrowingRequest insertBorrowingRequest) throws Exception {
        Borrowing borrowing = findBorrowingRecord(bookId, patronId);
        if(borrowing!= null){
                throw new SQLDataException("borrow record had been stored before");
            } else {
                java.util.Date utilDate = new java.util.Date();  // Current date
                Date sqlDate = new Date(utilDate.getTime());
                borrowing.setBorrowDate(sqlDate);
                borrowingDAO.save(borrowing);
            }
    }

    @Override
    public void updateBorrowingRecord(int bookId, int patronId) throws Exception{

        Borrowing borrowing = findBorrowingRecord(bookId, patronId);
        if(borrowing == null){
            throw new NotFound("borrow record is not found");
        } else {
            java.util.Date utilDate = new java.util.Date();  // Current date
            Date sqlDate = new Date(utilDate.getTime());
            borrowing.setReturnDate(sqlDate);
            borrowingDAO.save(borrowing);
        }
    }

    @Override
    public Borrowing findBorrowingRecord(int bookId, int patronId) throws Exception {
        Book book = bookService.findBook(bookId);
        Patron patron = patronService.findPatron(patronId);
        BorrowingCompositeKeyId borrowingCompositeKeyId = new BorrowingCompositeKeyId(book, patron);
        return borrowingDAO.getById(borrowingCompositeKeyId);
    }


}
