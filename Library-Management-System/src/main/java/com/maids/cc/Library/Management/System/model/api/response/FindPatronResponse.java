package com.maids.cc.Library.Management.System.model.api.response;

import com.maids.cc.Library.Management.System.model.entity.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindPatronResponse {
    private Patron patron;
}
