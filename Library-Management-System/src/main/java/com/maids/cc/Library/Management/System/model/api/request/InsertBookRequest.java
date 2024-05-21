package com.maids.cc.Library.Management.System.model.api.request;

import com.maids.cc.Library.Management.System.model.entity.Book;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertBookRequest {
    private Book book;
}
