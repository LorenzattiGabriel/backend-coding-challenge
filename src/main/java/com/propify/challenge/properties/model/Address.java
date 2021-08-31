package com.propify.challenge.properties.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {


    private Long id;

    public String street; // must not be null or blank

    public String city; // must not be null or blank

    public String state; // 2-letter code, must not be null or blank

    public String zip; // 5-digit code, must not be null or blank

    public String timezone; // Must be a valid timezone


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
