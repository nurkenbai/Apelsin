package com.company.dto.response;

import com.company.dto.request.ProfileRequestDTO;
import com.company.enums.ProfileStatus;
import com.company.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProfileResponseDTO extends ProfileRequestDTO {
    private String id;
    private LocalDateTime createdDate;
    private ProfileStatus status;
}
