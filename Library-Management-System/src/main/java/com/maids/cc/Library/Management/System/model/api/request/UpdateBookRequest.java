package com.maids.cc.Library.Management.System.model.api.request;

import com.maids.cc.Library.Management.System.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookRequest {
    private Book book;
}
