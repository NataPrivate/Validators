package example.java.validators;

import lombok.*;
import java.lang.annotation.*;
import java.math.BigDecimal;
import java.util.*;
import javax.validation.constraints.*;
import javax.validation.*;
import org.hibernate.validator.constraints.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;



@AllArgsConstructor
public class InternetOrder {
    public enum Delivery {Post, Courier, Self}

    @NotNull(message = "Enter a date")
    @PastOrPresent(message = "Invalid date")
    @Getter @Setter private Calendar orderDate;

    @javax.validation.constraints.NotEmpty(message = "Enter a map with at least 1 element")
    @Getter @Setter private Map<Good, Integer> goodsQuantity;

    @NotNull(message = "Enter a buyer")
    @Valid
    @Getter @Setter private Buyer buyer;

    @NotNull(message = "Enter a price")
    @DecimalMin(value = "0.1", message = "Is it free?")
    @Getter @Setter private BigDecimal finalPrice;

    @javax.validation.constraints.NotEmpty(message = "Enter an url")
    @Pattern(regexp = "^(http://|https://|www.)?((\\S+/)+|\\S)(\\S*)$", message = "Invalid url")
    @Getter @Setter private String webSiteUrl;

    @NotNull(message = "Enter an orderId")
    @Getter @Setter private UUID orderId;

    @NotNull(message = "Select a deliveryType")
    @Getter @Setter private Delivery deliveryType;

    @Range(min = 1, max = 5, message = "Invalid value of mark")
    @Getter @Setter private int feedbackMark;

    @Getter @Setter private char[] comment;
}
