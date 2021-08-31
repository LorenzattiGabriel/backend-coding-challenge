package com.propify.challenge.properties.services;

import com.propify.challenge.properties.model.Property;
import com.propify.challenge.properties.model.PropertyReport;
import com.propify.challenge.properties.web.Dtos.PropertyDto;

import java.util.List;

public interface PropertyOperations {

    List<Property> search(double minRentPrice, double maxRentPrice);

    Property findById(Integer id) throws Exception;

    void save(PropertyDto propertyDto);

    Property update(PropertyDto propertyDto);

    void delete(Integer id);

    PropertyReport generateReport();
}
