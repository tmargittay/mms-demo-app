package com.tsystems.mms.demoapp.user.controller;

import com.tsystems.mms.demoapp.user.dto.UnitCreateCommand;
import com.tsystems.mms.demoapp.user.dto.UnitInstanceItem;
import com.tsystems.mms.demoapp.user.dto.UserCreateCommand;
import com.tsystems.mms.demoapp.user.dto.UserInstanceItem;
import com.tsystems.mms.demoapp.user.service.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0")
public class UnitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitController.class);
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/unit")
    public ResponseEntity<List<UnitInstanceItem>> getUnits() {
        LOGGER.info("Get all units from the database");
        return new ResponseEntity<>(unitService.getAllUnits(), HttpStatus.OK);
    }

    @GetMapping("/unit/{id}")
    public ResponseEntity<UnitInstanceItem> getUnitById(@PathVariable Long id) {
        return new ResponseEntity<>(unitService.getUnitById(id), HttpStatus.OK);
    }
    @PostMapping("/unit")
    public ResponseEntity<UnitInstanceItem> createUnit(@RequestBody UnitCreateCommand command) {
        return new ResponseEntity<>(unitService.createUnit(command),HttpStatus.CREATED);
    }
}