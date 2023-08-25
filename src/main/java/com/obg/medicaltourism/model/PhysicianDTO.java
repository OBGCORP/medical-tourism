package com.obg.medicaltourism.model;

import com.obg.medicaltourism.utility.BaseDTO;
import lombok.Data;

@Data
public class PhysicianDTO extends BaseDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
}
