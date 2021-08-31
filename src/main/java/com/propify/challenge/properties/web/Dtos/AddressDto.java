package com.propify.challenge.properties.web.Dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    @Setter
    @Getter
    @NotNull
    @NotBlank
    public String street; // must not be null or blank

    @Setter
    @Getter
    @NotNull
    @NotBlank
    public String city; // must not be null or blank

    @Setter
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 2, message
            = "zip  must be 5 characters")
    public String state; // 2-letter code, must not be null or blank

    @Setter
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 5, max = 5, message
            = "zip  must be 5 characters")
    public String zip; // 5-digit code, must not be null or blank

    @Setter
    @Getter
    public String timezone; // Must be a valid timezone


}
