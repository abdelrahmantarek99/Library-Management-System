package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.Exception.NotFound;
import com.maids.cc.Library.Management.System.model.api.request.InsertPatronRequest;
import com.maids.cc.Library.Management.System.model.api.request.UpdatePatronRequest;
import com.maids.cc.Library.Management.System.model.api.response.FindPatronResponse;
import com.maids.cc.Library.Management.System.model.api.response.FindPatronsResponse;
import com.maids.cc.Library.Management.System.model.entity.Patron;
import com.maids.cc.Library.Management.System.service.framework.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    final PatronService patronService;
    @GetMapping
    public ResponseEntity<FindPatronsResponse> findPatrons(){ ///Retrieve a list of all patrons.
        try {
            FindPatronsResponse findPatronsResponse = new FindPatronsResponse(patronService.findPatrons());
            return new ResponseEntity<>(findPatronsResponse, HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindPatronResponse> findPatron(@PathVariable(name = "id") int id){ ///Retrieve details of a specific patron by ID.
        try {
            FindPatronResponse findPatronResponse = new FindPatronResponse(patronService.findPatron(id));
            return new ResponseEntity<>(findPatronResponse, HttpStatus.OK);
        } catch (NotFound e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Void> insertPatron(@RequestBody InsertPatronRequest patronRequest){ /// Add a new patron to the system.
        try {
            patronService.insertPatron(patronRequest.getPatron());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePatron(@PathVariable int id, @RequestBody UpdatePatronRequest updatePatronRequest){ ///Update an existing patron's information.
        try {
            patronService.updatePatron(id, updatePatronRequest.getPatron());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFound ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePatron(@PathVariable int id){ ///Remove a patron from the system.
        try {
            patronService.removePatron(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

