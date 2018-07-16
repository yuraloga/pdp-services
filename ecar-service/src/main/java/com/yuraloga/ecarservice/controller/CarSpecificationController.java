package com.yuraloga.ecarservice.controller;

import com.yuraloga.ecarservice.model.CarSpecification;
import com.yuraloga.ecarservice.service.CarSpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/car-specification")
    public ResponseEntity<List<CarSpecification>> getCarSpecifications(@RequestParam("modelName") String modelName) {
        return new ResponseEntity<>(
                carSpecificationService.getCarSpecificationByModelNameStartingWith(modelName),
                HttpStatus.OK
        );
    }

}
