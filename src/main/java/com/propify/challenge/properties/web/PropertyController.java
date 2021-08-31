package com.propify.challenge.properties.web;

import com.propify.challenge.properties.model.Property;
import com.propify.challenge.properties.model.PropertyReport;

import com.propify.challenge.properties.services.PropertyOperations;
import com.propify.challenge.properties.web.Dtos.PropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(value = "/properties/")
public class PropertyController {

    PropertyOperations service;

    @Autowired
    public PropertyController(PropertyOperations service) {
        this.service = service;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<?> search(
            @RequestParam @NotNull @Positive double minRentPrice,
            @RequestParam @NotNull @Positive double maxRentPrice) {

        final List<Property> properties = service.search(minRentPrice, maxRentPrice);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") @NotNull @Positive Integer id) throws Exception {
        final Property property = service.findById(id);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@Valid @RequestBody PropertyDto propertyDto) {
        if (propertyDto.getAddress().validateTimezone()) {
            service.save(propertyDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody PropertyDto propertyDto) {
        Property property = service.update(propertyDto);
        return new ResponseEntity<>(property, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") @NotNull @Positive Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ResponseEntity<?> report() {
        PropertyReport propertyReport = service.generateReport();
        return new ResponseEntity<>(propertyReport, HttpStatus.CREATED);
    }
}
