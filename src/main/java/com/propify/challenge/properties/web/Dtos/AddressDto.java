package com.propify.challenge.properties.web.Dtos;

import javassist.tools.web.BadHttpRequest;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.TimeZone;

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


    public boolean validateTimezone()  {
        String[] validIDs = TimeZone.getAvailableIDs();
        for (String str : validIDs) {
            if (str != null && str.equals(timezone)) {
                return true;
            }
        }
        return false;
    }
}
