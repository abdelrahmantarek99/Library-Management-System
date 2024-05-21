package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.Exception.NotFound;
import com.maids.cc.Library.Management.System.model.api.response.FindBookResponse;
import com.maids.cc.Library.Management.System.model.api.request.InsertBookRequest;
import com.maids.cc.Library.Management.System.model.api.request.UpdateBookRequest;
import com.maids.cc.Library.Management.System.model.api.response.FindBooksResponse;
import com.maids.cc.Library.Management.System.service.framework.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    final private BookService bookService;

    @GetMapping
    public ResponseEntity<FindBooksResponse> findBooks(){///Retrieve a list of all books.
        try{
            FindBooksResponse findBooksResponse = new FindBooksResponse(bookService.findBooks());
            return new ResponseEntity<>(findBooksResponse, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping( "/{id}")
    public ResponseEntity<FindBookResponse> findBook(@PathVariable("id") int id){///Retrieve details of a specific book by ID.
        try{
            FindBookResponse findBookResponse = new FindBookResponse(bookService.findBook(id));
            return new ResponseEntity<>(findBookResponse, HttpStatus.OK);
        } catch (NotFound e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> insertBook(@RequestBody InsertBookRequest bookRequest ){///Add a new book to the library.
        try{
            bookService.insertBook(bookRequest.getBook());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping( "/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable int id, @RequestBody UpdateBookRequest bookRequest){///Update an existing book's information.
        try{
            bookService.updateBook(id, bookRequest.getBook());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFound e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){///Remove a book from the library.
        try{
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
