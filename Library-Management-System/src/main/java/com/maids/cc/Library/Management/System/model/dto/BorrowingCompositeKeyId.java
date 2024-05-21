package com.maids.cc.Library.Management.System.model.dto;

import com.maids.cc.Library.Management.System.model.entity.Book;
import com.maids.cc.Library.Management.System.model.entity.Patron;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
public class BorrowingCompositeKeyId implements Serializable{
    private Book book;
    private Patron patron;
}
