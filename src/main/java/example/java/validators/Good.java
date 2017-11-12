package example.java.validators;

import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import java.math.BigDecimal;


@AllArgsConstructor
public class Good {
    @javax.validation.constraints.NotEmpty(message = "Enter a name")
    @Length(min = 3, max = 80, message = "Name is too short or big")
    @Getter @Setter private String name;

    @NotNull(message = "Enter a price")
    @DecimalMin(value = "0.1", message = "Is it free?")
    @Getter @Setter private BigDecimal price;

    @javax.validation.constraints.NotEmpty(message = "Enter a manufacturer")
    @Length(min = 2, max = 80, message = "Manufacturer is too short or big")
    @Getter @Setter private String manufacturer;

    @Getter @Setter private String description;
}
