package com.maids.cc.Library.Management.System.service.framework;

import com.maids.cc.Library.Management.System.model.entity.Patron;

import java.util.List;

public interface PatronService {
    List<Patron> findPatrons() throws Exception;
    Patron findPatron(int id) throws Exception; ///Retrieve details of a specific patron by ID.
    void insertPatron(Patron patron) throws Exception;
    void updatePatron(int id, Patron patron) throws Exception;///Update an existing patron's information.
    void removePatron(int id) throws Exception;///Remove a patron from the system.
}
