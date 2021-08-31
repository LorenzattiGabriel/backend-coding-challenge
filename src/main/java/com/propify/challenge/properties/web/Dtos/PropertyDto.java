package com.propify.challenge.properties.web.Dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.propify.challenge.properties.model.Type;
import com.propify.challenge.properties.web.Dtos.AddressDto;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {

    @Setter
    @Getter
    public String createTime;

    @JsonProperty(required = true)
    @Setter
    @Getter
    public Type type;

    @JsonProperty(required = true)
    @Positive
    @Setter
    @Min(value = 1, message = "rentPrice should not be less than 1")
    @Digits(fraction = 2, message = "rentPrice should have two decimals1", integer = 6)
    @Getter
    public double rentPrice; // must be greater than 0, 2 decimal places

    @NotNull
    @Setter
    @Getter
    public AddressDto address; // must not be null

    @Email
    @Setter
    @Getter
    public String emailAddress; // must be a valid email address

    @NotNull
    @Setter
    @Getter
    @Pattern(regexp = "(?=.*[A-Z])[\\p{Punct}A-Z0-9 ]{1,999999999}", message = "Error")
    @Size(min = 10, max = 10, message
            = "code  must be 10 characters")
    public String code; // not null, only uppercase letters or numbers, 10 characters
}
