package com.company.service;

import com.company.dto.request.ProfileChangeStatusRequestDTO;
import com.company.dto.request.ProfileRequestDTO;
import com.company.dto.response.ProfileResponseDTO;
import com.company.entity.ProfileEntity;
import com.company.enums.ProfileRole;
import com.company.enums.ProfileStatus;
import com.company.exception.ItemNotFoundException;
import com.company.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;


    public ProfileResponseDTO create(ProfileRequestDTO requestDTO) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(requestDTO.getName());
        entity.setSurname(requestDTO.getSurname());
        entity.setPhone(requestDTO.getSurname());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setRole(ProfileRole.USER);
        return toDTO(entity);
    }

    public ProfileResponseDTO getById(String id) {
        ProfileEntity entity = profileRepository.findByIdAndVisible(id, true).orElseThrow(() -> {
            log.warn("Profile id not found");
            throw new ItemNotFoundException("Profile id not found");
        });
        return toDTO(entity);
    }

    public List<ProfileResponseDTO> getAll() {
        List<ProfileResponseDTO> profileList = new LinkedList<>();
        profileRepository.findAllByVisible(true).forEach(entity -> {
            profileList.add(toDTO(entity));
        });
        return profileList;
    }

    public Boolean delete(String id) {
        int n = profileRepository.deleteStatus(false, id);
        return n > 0;
    }

    public Boolean changeStatus(String id, ProfileChangeStatusRequestDTO requestDTO) {
        int n = profileRepository.changeStatus(requestDTO.getStatus(), id);
        return n > 0;
    }

    private ProfileResponseDTO toDTO(ProfileEntity entity) {
        ProfileResponseDTO responseDTO = new ProfileResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setStatus(entity.getStatus());
        responseDTO.setName(entity.getName());
        responseDTO.setSurname(entity.getSurname());
        responseDTO.setPhone(entity.getPhone());
        responseDTO.setCreatedDate(entity.getCreatedDate());
        return responseDTO;
    }

}
