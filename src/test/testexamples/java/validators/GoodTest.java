package testexamples.java.validators;

import example.java.validators.Good;
import org.junit.*;
import javax.validation.*;
import java.math.BigDecimal;
import java.util.Set;
import static org.junit.Assert.*;


public class GoodTest {
    Validator validator;
    Good good;

    @Before
    public void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        good = new Good("Dream Umbrella", new BigDecimal(405.0), "UmbrellaFactory", "An umbrella of your dream");
    }

    @Test
    public void testName() {
        good.setName("it");
        Set<ConstraintViolation<Good>> constraintViolations = validator.validate(good);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Name is too short or big", constraintViolations.iterator().next().getMessage());
        good.setName(null);
        constraintViolations = validator.validate(good);
        assertNull( good.getName());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter a name", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testPrice() {
        good.setPrice(new BigDecimal(0));
        Set<ConstraintViolation<Good>> constraintViolations = validator.validate(good);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Is it free?", constraintViolations.iterator().next().getMessage());
        good.setPrice(null);
        constraintViolations = validator.validate(good);
        assertNull( good.getPrice());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter a price", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testManufacturer() {
        good.setManufacturer("I");
        Set<ConstraintViolation<Good>> constraintViolations = validator.validate(good);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Manufacturer is too short or big", constraintViolations.iterator().next().getMessage());
        good.setManufacturer(null);
        constraintViolations = validator.validate(good);
        assertNull( good.getManufacturer());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter a manufacturer", constraintViolations.iterator().next().getMessage());
    }
}