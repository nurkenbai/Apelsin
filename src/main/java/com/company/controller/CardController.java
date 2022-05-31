package com.company.controller;

import com.company.dto.request.CardAssignRequestDTO;
import com.company.dto.request.CardRequestDTO;
import com.company.enums.CardStatus;
import com.company.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Slf4j
@Api(tags = "Card")
@RestController
@RequestMapping("/v1/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @ApiOperation(value = "Create ", notes = "Method Create Card")
    @PreAuthorize("hasRole('BANK')")
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid CardRequestDTO requestDTO) {
        log.info("Create: {}",requestDTO);
        return ResponseEntity.ok(cardService.create(requestDTO));
    }



    @ApiOperation(value = "Get by id", notes = "Method get By id")
    @PreAuthorize("hasRole('BANK')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        log.info("Get by id: {}",id);
        return ResponseEntity.ok(cardService.getById(id));
    }

    @ApiOperation(value = "Get by Card number", notes = "Method get By Card number")
    @GetMapping("/getByCardNumber/{id}")
    public ResponseEntity<?> getByCardNumber(@PathVariable("id") String id) {
        log.info("Get by card number: {}",id);
        return ResponseEntity.ok(cardService.getByCardNumber(id));
    }

    @ApiOperation(value = "Get by Profile Id", notes = "Method get By Profile Id")
    @GetMapping("/getByClientId/{id}")
    public ResponseEntity<?> getByProfile(@PathVariable("id") String id) {
        log.info("Get by profile id: {}",id);
        return ResponseEntity.ok(cardService.getByProfile(id));
    }

    @ApiOperation(value = "Get by Phone Id", notes = "Method get By Phone Id")
    @GetMapping("/getByPhoneId/{id}")
    public ResponseEntity<?> getByPhoneId(@PathVariable("id") String id) {
        log.info("Get by phone: {}",id);
        return ResponseEntity.ok(cardService.getByPhoneId(id));
    }

    @ApiOperation(value = "Get by Card number Balance", notes = "Method get By Card number Balance")
    @GetMapping("/getBalance/{number}")
    public ResponseEntity<?> getBalance(@PathVariable("number") String number) {
        log.info("Get balance by card number: {}",number);
        return ResponseEntity.ok(cardService.getBalance(number));
    }


    @ApiOperation(value = "Cheng Status", notes = "Method Cheng Status by id Active")
    @PreAuthorize("hasRole('BANK')")
    @PutMapping("/chengStatus/{id}/Active")
    public ResponseEntity<?> chengStatusActive(@PathVariable("id") String id) {
        log.info("Chang status active: {}",id);
        return ResponseEntity.ok(cardService.chengStatus(CardStatus.ACTIVE, id));
    }

    @ApiOperation(value = "Cheng Status", notes = "Method Cheng Status by id Active")
    @PreAuthorize("hasRole('BANK')")
    @PutMapping("/assignPhone/{id}")
    public ResponseEntity<?> assignPhone(@PathVariable("id") String id,
                                         @RequestBody @Valid CardAssignRequestDTO requestDTO) {
        log.info("Assign phone: {},{}",requestDTO,id);
        return ResponseEntity.ok(cardService.assignPhone(requestDTO.getPhone(), id));
    }

    @ApiOperation(value = "Cheng Status", notes = "Method Cheng Status by id block")
    @PreAuthorize("hasRole('BANK')")
    @PutMapping("/chengStatus/{id}/block")
    public ResponseEntity<?> chengStatusBlock(@PathVariable("id") String id) {
        log.info("Chang status block: {}",id);
        return ResponseEntity.ok(cardService.chengStatus(CardStatus.BLOCK, id));
    }

    @ApiOperation(value = "Cheng Status", notes = "Method Cheng Status by id Not active")
    @PreAuthorize("hasRole('BANK')")
    @PutMapping("/chengStatus/{id}/notactive")
    public ResponseEntity<?> chengStatusNotActive(@PathVariable("id") String id) {
        log.info("Chang status not active: {}",id);
        return ResponseEntity.ok(cardService.chengStatus(CardStatus.NOT_ACTIVE, id));
    }
}
