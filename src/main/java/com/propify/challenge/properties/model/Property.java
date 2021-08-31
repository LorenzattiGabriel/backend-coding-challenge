package com.propify.challenge.properties.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property implements Serializable {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id; // must be null for INSERT and not null for UPDATE

    @Setter
    @Getter
    public String createTime;

    @Setter
    @Getter
    public Type type;

    @Setter
    @Getter
    public double rentPrice; // must be greater than 0, 2 decimal places

    @Setter
    @Getter
    @OneToOne
    public Address address; // must not be null

    @Setter
    @Getter
    public String emailAddress; // must be a valid email address

    @Setter
    @Getter
    public String code; // not null, only uppercase letters or numbers, 10 characters

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Property property;

        public Builder() {
            this.property = new Property();
        }

        public Builder withAddress(Address address) {
            property.setAddress(address);
            return this;
        }

        public Builder withTime(String time) {
            property.setCreateTime(time);
            return this;
        }

        public Builder withType(Type type) {
            property.setType(type);
            return this;
        }

        public Builder withPrice(double price) {
            property.setRentPrice(price);
            return this;
        }

        public Builder withEmail(String email) {
            property.setEmailAddress(email);
            return this;
        }

        public Builder withCode(String code) {
            property.setCode(code);
            return this;
        }
        public Property build() {
            return property;
        }
    }
}
