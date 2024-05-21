package com.maids.cc.Library.Management.System.model.api.request;

import com.maids.cc.Library.Management.System.model.entity.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePatronRequest {
    private Patron patron;
}
