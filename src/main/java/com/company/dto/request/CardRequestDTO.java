package com.company.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class CardRequestDTO {
    private String number;
    private String name;
    private String expiryDate;
}
