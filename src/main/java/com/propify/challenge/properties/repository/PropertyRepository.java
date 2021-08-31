package com.propify.challenge.properties.repository;

import com.propify.challenge.properties.model.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {
}
