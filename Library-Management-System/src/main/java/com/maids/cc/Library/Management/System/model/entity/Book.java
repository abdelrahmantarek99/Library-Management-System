package com.maids.cc.Library.Management.System.model.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table( name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specify the generation strategy
    @Column(name = "ID")
    private int id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    @Column(name = "PUBLICATION_YEAR")
    private int publicationYear;
    @Column(name = "ISBN")
    private String isbn;
}
