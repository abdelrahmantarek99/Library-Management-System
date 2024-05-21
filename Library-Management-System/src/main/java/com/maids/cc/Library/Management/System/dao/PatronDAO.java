package com.maids.cc.Library.Management.System.dao;

import com.maids.cc.Library.Management.System.model.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronDAO extends JpaRepository<Patron, Integer> {
}
