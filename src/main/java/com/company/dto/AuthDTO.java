package com.company.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthDTO {
    @NotNull(message = "phone required")
    @Size(min = 9, max = 13, message = "Phone not valid")
    private String phone;
    @NotBlank(message = "Password required")
    @Size(min = 6, max = 20, message = "About Me must between 6 and 20 characters")
    private String password;

    private String jwt;
}
