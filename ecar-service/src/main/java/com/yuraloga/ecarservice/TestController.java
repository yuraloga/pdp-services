package com.yuraloga.ecarservice;

import com.yuraloga.ecarservice.exceptions.NotFoundException;
import com.yuraloga.ecarservice.model.AutomobileManufacturer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/car-manufactures")
    public Collection<AutomobileManufacturer> getAutomobileManufacturers() {
        return automobileManufacturers;
    }

    @GetMapping("/car-manufactures/{id}")
    public AutomobileManufacturer getAutomobileManufacturer(@PathVariable("id") Integer id) {
        AutomobileManufacturer automobileManufacturer = automobileManufacturerMap.get(id);
        if (isNull(automobileManufacturer)) {
            throw new NotFoundException("");
        }
        return automobileManufacturer;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public void handleNotFoundException(NotFoundException e) {
        log.warn("Object was not found", e);
    }

    private static final Collection<AutomobileManufacturer> automobileManufacturers = Collections.unmodifiableCollection(
            Arrays.asList(
                    AutomobileManufacturer.builder()
                            .id(1)
                            .logoId(1)
                            .name("Audi")
                            .build(),
                    AutomobileManufacturer.builder()
                            .id(2)
                            .logoId(2)
                            .name("BMW")
                            .build(),
                    AutomobileManufacturer.builder()
                            .id(3)
                            .logoId(3)
                            .name("Porsche")
                            .build(),
                    AutomobileManufacturer.builder()
                            .id(4)
                            .logoId(4)
                            .name("Volkswagen")
                            .build(),
                    AutomobileManufacturer.builder()
                            .id(5)
                            .logoId(5)
                            .name("Merсedes-Benz")
                            .build())
    );

    private static final Map<Integer, AutomobileManufacturer> automobileManufacturerMap = automobileManufacturers.stream()
            .collect(Collectors.toMap(AutomobileManufacturer::getId, e -> e));
}
