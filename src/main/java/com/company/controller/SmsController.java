package com.company.controller;

import com.company.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "Sms")
@RestController
@RequestMapping("/v1/sms")
public class SmsController {
    @Autowired
    private SmsService smsService;

    @ApiOperation(value = "Sms Resend")
    @GetMapping("/{id}")
    public ResponseEntity<?> resend(@PathVariable("id") String id) {
        return ResponseEntity.ok(smsService.resendSms(id));
    }
}
