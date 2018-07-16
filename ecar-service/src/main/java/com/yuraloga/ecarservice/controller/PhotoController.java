package com.yuraloga.ecarservice.controller;

import com.yuraloga.ecarservice.model.Photo;
import com.yuraloga.ecarservice.service.PhotoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping("/photo/{id}")
    public ResponseEntity<Photo> getCarSpecification(@PathVariable Integer id) {
        return new ResponseEntity<>(
                photoService.getPhotoById(id),
                HttpStatus.OK
        );
    }
}
