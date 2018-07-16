package com.yuraloga.ecarservice.controller;

import com.yuraloga.ecarservice.model.PhotoSet;
import com.yuraloga.ecarservice.service.PhotoSetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PhotoSetController {
    private final PhotoSetService photoSetService;

    @GetMapping("/photoset/{photoSetId}")
    public ResponseEntity<PhotoSet> getPhotoSet(@PathVariable Integer photoSetId) {
        return new ResponseEntity<>(
                photoSetService.getPhotoSetById(photoSetId),
                HttpStatus.OK
        );
    }
}
