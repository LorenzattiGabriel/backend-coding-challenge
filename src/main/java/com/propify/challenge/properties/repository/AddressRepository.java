package com.propify.challenge.properties.repository;

import com.propify.challenge.properties.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
