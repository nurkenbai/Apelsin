package com.company.dto.response;

import com.company.dto.request.CardRequestDTO;
import com.company.enums.CardStatus;
import com.company.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardResponseDTO extends CardRequestDTO {
    private String id;
    private Long balance;
    private LocalDateTime createdDate;
    private CardStatus status;
    private LocalDate expiryDates;
    @NotBlank(message = "The profile Id should not be empty")
    private String profileId;
    private ProfileResponseDTO profile;
    private String phone;

}
