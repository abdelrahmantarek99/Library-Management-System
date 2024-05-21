package com.maids.cc.Library.Management.System.dao;

import com.maids.cc.Library.Management.System.model.dto.BorrowingCompositeKeyId;
import com.maids.cc.Library.Management.System.model.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingDAO extends JpaRepository<Borrowing, BorrowingCompositeKeyId> {
}
