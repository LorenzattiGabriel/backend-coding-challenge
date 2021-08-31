package com.propify.challenge.properties.services;

import com.propify.challenge.properties.model.Address;
import com.propify.challenge.properties.model.Property;
import com.propify.challenge.properties.model.PropertyReport;
import com.propify.challenge.properties.repository.AddressRepository;
import com.propify.challenge.properties.repository.PropertyRepository;
import com.propify.challenge.properties.web.Dtos.AddressDto;
import com.propify.challenge.properties.web.Dtos.PropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public Property findById(Integer id) throws Exception {
        Long propertyID = (long) id;
        Optional<Property> property = propertyRepository.findById(propertyID);

        return property.orElseThrow(() -> new Exception("property not found"));

    }

    @Override
    public void save(PropertyDto propertyDto) {
        Property property = generateNewProperty(propertyDto);
        propertyRepository.save(property);
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


    private Property generateNewProperty(PropertyDto propertyDto) {
        Address address = buildAddress(propertyDto.getAddress());
        String time = LocalDateTime.now().toString();
        return Property.builder()
                .withAddress(address)
                .withTime(time)
                .withType(propertyDto.getType())
                .withPrice(propertyDto.getRentPrice())
                .withEmail(propertyDto.getEmailAddress())
                .withCode(propertyDto.getCode())
                .build();
    }

    private Address buildAddress(AddressDto addressDto) {
        return Address.builder()
                .withStreet(addressDto.getStreet())
                .withCity(addressDto.getCity())
                .withState(addressDto.getState())
                .withTimezone(addressDto.getTimezone())
                .withZip(addressDto.getZip())
                .build();
    }

}
