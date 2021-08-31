package com.propify.challenge.properties.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    public String street; // must not be null or blank

    @Setter
    @Getter
    public String city; // must not be null or blank

    @Setter
    @Getter
    public String state; // 2-letter code, must not be null or blank

    @Setter
    @Getter
    public String zip; // 5-digit code, must not be null or blank

    @Setter
    @Getter
    public String timezone; // Must be a valid timezone


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
