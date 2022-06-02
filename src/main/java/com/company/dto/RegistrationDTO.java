package com.company.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
public class RegistrationDTO {
    @NotNull
    @Size(min = 3, max = 25, message = "name requaried")
    private String name;
    @NotNull
    @Size(min = 3, max = 25, message = "surname requaried")
    private String surname;
    @NotNull
    @NotBlank(message = "phone required")
    @Size(min = 12, max = 12, message = "phone requaired")
    private String phone;
    @NotBlank(message = "password required")
    @Size(min = 6, max = 12, message = "password requaired")
    private String password;
}
