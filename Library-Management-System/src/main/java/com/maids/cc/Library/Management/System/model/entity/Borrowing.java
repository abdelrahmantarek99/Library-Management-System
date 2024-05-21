package com.maids.cc.Library.Management.System.model.entity;

import com.maids.cc.Library.Management.System.model.dto.BorrowingCompositeKeyId;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table( name = "Borrowing")
@IdClass(BorrowingCompositeKeyId.class)
public class Borrowing implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    @Id
    @ManyToOne
    @JoinColumn(name = "patronId")
    private Patron patron;

    @Column(name = "cost")
    private double cost;
    @Column(name = "borrowDate")
    private Date borrowDate;
    @Column(name = "returnDate")
    private Date returnDate;
}
