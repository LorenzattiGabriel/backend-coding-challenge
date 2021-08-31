package com.propify.challenge.properties.model;

import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyReport {

    @Setter
    @Getter
    Integer totalQuantity;

    @Setter
    @Getter
    Map<Type, Integer> quantityPerType;

    @Setter
    @Getter
    double averageRentPrice;

    @Setter
    @Getter
    Integer illinoisQuantity;
}
