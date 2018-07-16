package com.yuraloga.ecarservice.controller;

import com.yuraloga.ecarservice.model.CarSpecification;
import com.yuraloga.ecarservice.service.CarSpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarSpecificationController {
    private final CarSpecificationService carSpecificationService;

    @GetMapping("/car-specification/{id}")
    public ResponseEntity<CarSpecification> getCarSpecification(@PathVariable Integer id) {
        return new ResponseEntity<>(
                carSpecificationService.getCarSpecification(id),
                HttpStatus.OK
        );
    }

}
