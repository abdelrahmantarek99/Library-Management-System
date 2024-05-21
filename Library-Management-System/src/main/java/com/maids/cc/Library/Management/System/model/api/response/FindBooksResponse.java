package com.maids.cc.Library.Management.System.model.api.response;

import com.maids.cc.Library.Management.System.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindBooksResponse {
    private List<Book> books;
}
