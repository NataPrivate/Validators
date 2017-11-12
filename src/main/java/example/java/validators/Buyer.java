package example.java.validators;

import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

@AllArgsConstructor
public class Buyer {
    @javax.validation.constraints.Email(message = "Email is invalid")
    @Getter @Setter private String email;

    @javax.validation.constraints.NotEmpty(message = "Enter your fullName")
    @Length(min = 10, message = "Is your name really so short?")
    @Getter @Setter private String fullName;

    @javax.validation.constraints.NotEmpty(message = "Enter your phoneNumber")
    //@Pattern(regexp = "^(\\+38)?(?<bracket>\\()?0((9[11-9])|(73)|(6[367])|(50))(?(bracket)\))[- ]\\d{3}([- ]\\d{2}){2}$")
    @Pattern(regexp = "^(\\+38)?0((9[11-9])|(73)|(6[367])|(50))([- ])\\d{3}(\\7\\d{2}){2}$", message = "Number is invalid")
    @Getter @Setter private String phoneNumber;
}
