package com.obg.medicaltourism.model.requestDTO;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class PhysicianRequestDTO extends BaseDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
}
