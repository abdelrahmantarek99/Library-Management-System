package com.maids.cc.Library.Management.System.service.impl;

import com.maids.cc.Library.Management.System.Exception.NotFound;
import com.maids.cc.Library.Management.System.dao.PatronDAO;
import com.maids.cc.Library.Management.System.model.entity.Patron;
import com.maids.cc.Library.Management.System.service.framework.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatronServiceImpl implements PatronService {

    final private PatronDAO patronDAO;
    @Override
    public List<Patron> findPatrons() {
        return patronDAO.findAll();
    }

    @Override
    public Patron findPatron(int id) {
        Optional<Patron> patron = patronDAO.findById(id);
        if(patron.isPresent()){
            return patron.get();
        } else {
            throw new NotFound("patron is not found");
        }
    }

    @Override
    public void insertPatron(Patron patron) {
        patronDAO.save(patron);
    }

    @Override
    public void updatePatron(int id, Patron patron) {
        if(patronDAO.existsById(id)) {
            patron.setId(id);
            patronDAO.save(patron);
        } else {
            throw new NotFound("patron is not found");
        }
    }

    @Override
    public void removePatron(int id) {

    }

}
