package com.company.controller;

import com.company.dto.AuthDTO;
import com.company.dto.RegistrationDTO;
import com.company.dto.SmsDTO;
import com.company.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@Api(tags = "For Authorization")
public class AuthController {
    @Autowired
    private AuthService authService;

    @ApiOperation(value = "registration", notes = "Method for registration", nickname = "Mazgi")
    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody @Valid RegistrationDTO dto) {
        log.info("registration: {}", dto);
        authService.registration(dto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Login", notes = "Method Login")
    @PostMapping("/login")
    public ResponseEntity<AuthDTO> userLogin(@RequestBody @Valid AuthDTO dto) {
        log.warn("Auth login {}{}", dto, AuthController.class);
        return ResponseEntity.ok(authService.login(dto));
    }

    @ApiOperation(value = "activation", notes = "Method for activation", nickname = "Mazgi")
    @PostMapping("/activation")
    public ResponseEntity<?> activation(@RequestBody @Valid SmsDTO dto) {
        log.info("registration: {}", dto);
        return ResponseEntity.ok(authService.activation(dto));
    }
}
