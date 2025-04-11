package sam.association.oneToOne.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    //Added to check the duplicate constraint working - Good, it works.
    private Long id;

    private String name;

    private AddressDto addressDto;
}
