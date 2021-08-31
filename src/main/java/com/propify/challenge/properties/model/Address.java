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
    public Long id;

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

    @Id
    public Long getId() {
        return id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Address address;

        public Builder() {
            this.address = new Address();
        }

        public Builder withStreet(String street) {
            address.setStreet(street);
            return this;
        }

        public Builder withCity(String city) {
            address.setCity(city);
            return this;
        }

        public Builder withState(String state) {
            address.setState(state);
            return this;
        }

        public Builder withZip(String zip) {
            address.setZip(zip);
            return this;
        }

        public Builder withTimezone(String timezone) {
            address.setTimezone(timezone);
            return this;
        }
        public Address build() {
            return address;
        }
    }
}
