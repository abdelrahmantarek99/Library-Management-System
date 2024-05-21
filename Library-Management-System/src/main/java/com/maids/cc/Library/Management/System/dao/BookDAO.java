package com.maids.cc.Library.Management.System.dao;

import com.maids.cc.Library.Management.System.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Integer> {
}
