package com.propify.challenge.properties.web;

import com.propify.challenge.properties.model.Property;
import com.propify.challenge.properties.model.PropertyReport;

import com.propify.challenge.properties.services.PropertyOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/properties/")
public class PropertyController {

    PropertyOperations service;

    @Autowired
    public PropertyController(PropertyOperations service) {
        this.service = service;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Collection<Property> search(String minRentPrice, String maxRentPrice) {
        return service.search(minRentPrice, maxRentPrice);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Property findById(int id) {
        return propertyService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insert(Property property) {
        // TODO: Property attributes must be validated
        propertyService.insert(property);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(Property property) {
        // TODO: Property attributes must be validated
        propertyService.update(property);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(int id) {
        propertyService.delete(id);
    }


    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public PropertyReport report() {
        return propertyService.propertyReport();
    }
}
