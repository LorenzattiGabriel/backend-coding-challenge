package com.propify.challenge.properties.services;

import com.propify.challenge.properties.model.Property;
import com.propify.challenge.properties.model.PropertyReport;
import com.propify.challenge.properties.repository.AddressRepository;
import com.propify.challenge.properties.repository.PropertyRepository;
import com.propify.challenge.properties.web.Dtos.PropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements PropertyOperations {

    AlertOperations alertService;
    PropertyRepository propertyRepository;
    AddressRepository addressRepository;

    @Autowired
    public PropertyService(AlertOperations alertService, PropertyRepository propertyRepository,
                           AddressRepository addressRepository) {
        this.alertService = alertService;
        this.propertyRepository = propertyRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public List<Property> search(double minRentPrice, double maxRentPrice) {
        return null;
    }

    @Override
    public Property findById(Integer id) {
        return null;
    }

    @Override
    public void save(PropertyDto propertyDto) {
        System.out.println("CREATED: ");
    }

    @Override
    public Property update(PropertyDto propertyDto) {
        System.out.println("UPDATED: ");
        return null;
    }

    @Override
    public void delete(Integer id) {

        System.out.println("DELETED: " + id);
        alertService.sendPropertyDeletedAlert(id);
    }

    @Override
    public PropertyReport generateReport() {

        var allProperties = propertyRepository.findAll();
        var propertyReport = new PropertyReport();

        // Calculate total quantity
        // propertyReport.totalQuantity =

        // Calculate the quantity of each type, 0 if there is no properties.
        // propertyReport.quantityPerType =

        // Calculate the average rent price (exclude the properties without rent price or with rent price = 0)
        // propertyReport.averageRentPrice =

        // Calculate the quantity of properties in the state of Illinois (IL)
        // propertyReport.illinoisQuantity =

        return propertyReport;
    }
}
