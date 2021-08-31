package com.propify.challenge.properties.repository;

import com.propify.challenge.properties.model.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface AddressMapper {

    public void insert(Address address);

    public Set<Address> search();

    public Address findById(Integer id);

}