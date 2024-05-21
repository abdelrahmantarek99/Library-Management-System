package com.maids.cc.Library.Management.System.service.framework;

import com.maids.cc.Library.Management.System.model.api.request.InsertBorrowingRequest;
import com.maids.cc.Library.Management.System.model.entity.Book;
import com.maids.cc.Library.Management.System.model.entity.Borrowing;
import com.maids.cc.Library.Management.System.model.entity.Patron;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BorrowingService {
    void insertBorrowingRecord(int bookId ,int patronId, InsertBorrowingRequest insertBorrowingRequest) throws Exception;
    void updateBorrowingRecord(int bookId ,int patronId) throws Exception;/// Record the return of a borrowed book by a patron.
    Borrowing findBorrowingRecord(int bookId ,int patronId) throws Exception;

}
