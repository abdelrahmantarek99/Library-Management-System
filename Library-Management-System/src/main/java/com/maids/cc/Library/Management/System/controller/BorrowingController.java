package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.Exception.NotFound;
import com.maids.cc.Library.Management.System.model.api.request.InsertBorrowingRequest;
import com.maids.cc.Library.Management.System.model.entity.Borrowing;
import com.maids.cc.Library.Management.System.service.framework.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BorrowingController {

    final private BorrowingService borrowingService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<Void> insertBorrowingRecord(@PathVariable("bookId") int bookId , @PathVariable("patronId") int patronId, @RequestBody InsertBorrowingRequest insertBorrowingRequest){ /// Allow a patron to borrow a book.
        try {
            borrowingService.insertBorrowingRecord(bookId, patronId, insertBorrowingRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SQLDataException ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);///the data already saved before
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<Void> updateBorrowingRecord(@PathVariable("bookId") int bookId , @PathVariable("patronId") int patronId){ /// Record the return of a borrowed book by a patron.
        try {
            borrowingService.updateBorrowingRecord(bookId, patronId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFound e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/return/{bookId}/patron/{patronId}")

    public ResponseEntity<Borrowing> findBorrowingRecord(@PathVariable("bookId") int bookId , @PathVariable("patronId") int patronId){
        try {
            Borrowing borrowing = borrowingService.findBorrowingRecord(bookId, patronId);
            return new ResponseEntity<>(borrowing, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
