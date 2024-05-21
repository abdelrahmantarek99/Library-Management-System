package com.maids.cc.Library.Management.System.model.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertBorrowingRequest {
    private double cost;
}
