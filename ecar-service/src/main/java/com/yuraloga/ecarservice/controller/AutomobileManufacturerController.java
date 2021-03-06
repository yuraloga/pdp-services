package com.yuraloga.ecarservice.controller;

import com.yuraloga.ecarservice.model.AutomobileManufacturer;
import com.yuraloga.ecarservice.service.AutomobileManufacturerService;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class AutomobileManufacturerController {
    private final AutomobileManufacturerService automobileManufacturerService;

    @GetMapping("/car-model")
    public ResponseEntity<Page<AutomobileManufacturer>> getCarModels(@RequestParam(defaultValue = "1", required = false) @Range(min = 1) Integer page,
                                                                     @RequestParam(defaultValue = "10", required = false) @Range(min = 1, max = 50) Integer size,
                                                                     @RequestParam(defaultValue = "ASC", required = false) String sortOrder,
                                                                     @RequestParam(defaultValue = "name", required = false) String sortByProperty) {
        return new ResponseEntity<>(
                automobileManufacturerService.getCarModels(
                        PageRequest.of(page - 1, size, Sort.by(Sort.Direction.fromString(sortOrder), sortByProperty))
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/car-model")
    public ResponseEntity<AutomobileManufacturer> getCarModel(@RequestBody String name) {
        return new ResponseEntity<>(
                automobileManufacturerService.getCarModel(name),
                HttpStatus.OK
        );
    }
}
