package testexamples.java.validators;

import org.junit.*;
import javax.validation.*;
import example.java.validators.Buyer;
import java.util.Set;
import static org.junit.Assert.*;


public class BuyerTest {
    private Validator validator;
    private Buyer buyer;

    @Before
    public void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        buyer = new Buyer("natalsha07@gmail.com","Nata Litvinova", "+38095-325-50-65");
    }

    @Test
    public void testEmail() {
        buyer.setEmail("address");
        Set<ConstraintViolation<Buyer>> constraintViolations = validator.validate(buyer);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Email is invalid", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testFullName() {
        buyer.setFullName("User");
        Set<ConstraintViolation<Buyer>> constraintViolations = validator.validate(buyer);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Is your name really so short?", constraintViolations.iterator().next().getMessage());
        buyer.setFullName(null);
        constraintViolations = validator.validate(buyer);
        assertNull( buyer.getFullName());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter your fullName", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testPhoneNumber() {
        buyer.setPhoneNumber("023-432-54 11");
        Set<ConstraintViolation<Buyer>> constraintViolations = validator.validate(buyer);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Number is invalid", constraintViolations.iterator().next().getMessage());
        buyer.setPhoneNumber(null);
        constraintViolations = validator.validate(buyer);
        assertNull( buyer.getPhoneNumber());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter your phoneNumber", constraintViolations.iterator().next().getMessage());
    }
}