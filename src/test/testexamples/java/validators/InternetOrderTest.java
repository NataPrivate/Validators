package testexamples.java.validators;

import example.java.validators.*;
import org.junit.*;
import javax.validation.*;
import java.math.BigDecimal;
import java.util.*;
import static org.junit.Assert.*;


public class InternetOrderTest {
    private Validator validator;
    private InternetOrder order;

    @Before
    public void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Map<Good, Integer> goodsQuantity = new HashMap<>();
        goodsQuantity.put(new Good("Dream Umbrella", new BigDecimal(405.0), "UmbrellaFactory", "An umbrella of your dream"), 2);
        goodsQuantity.put(new Good("Best Socks", new BigDecimal(69.99), "Sooooocks", "Look at this socks!"), 1);
        Buyer buyer = new Buyer("natalsha07@gmail.com","Nata Litvinova", "+38095-325-50-65");
        order = new InternetOrder(new GregorianCalendar(2016, 12, 5, 12, 52),
                goodsQuantity, buyer, new BigDecimal(108.3), "aliexpress.com",
                UUID.randomUUID(), InternetOrder.Delivery.Self, 4, new char[] {'g', 'o', 'o', 'd'});
    }

    @Test
    public void testDate() {
        order.setOrderDate(new GregorianCalendar(2019, 11, 30));
        Set<ConstraintViolation<InternetOrder>> constraintViolations = validator.validate(order);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Invalid date", constraintViolations.iterator().next().getMessage());
        order.setOrderDate(null);
        constraintViolations = validator.validate(order);
        assertNull( order.getOrderDate());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter a date", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testMap() {
        order.setGoodsQuantity(null);
        Set<ConstraintViolation<InternetOrder>> constraintViolations = validator.validate(order);
        assertNull( order.getGoodsQuantity());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter a map with at least 1 element", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testBuyer() {
        order.setBuyer(new Buyer("", "", ""));
        Set<ConstraintViolation<InternetOrder>> constraintViolations = validator.validate(order);
        assertEquals( 4, constraintViolations.size() );
        order.setBuyer(null);
        constraintViolations = validator.validate(order);
        assertNull( order.getBuyer());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter a buyer", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testPrice() {
        order.setFinalPrice(new BigDecimal(0));
        Set<ConstraintViolation<InternetOrder>> constraintViolations = validator.validate(order);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Is it free?", constraintViolations.iterator().next().getMessage());
        order.setFinalPrice(null);
        constraintViolations = validator.validate(order);
        assertNull( order.getFinalPrice());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter a price", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testUrl() {
        order.setWebSiteUrl("023-432-54 11");
        Set<ConstraintViolation<InternetOrder>> constraintViolations = validator.validate(order);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Invalid url", constraintViolations.iterator().next().getMessage());
        order.setWebSiteUrl(null);
        constraintViolations = validator.validate(order);
        assertNull( order.getWebSiteUrl());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter an url", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testUUID() {
        order.setOrderId(null);
        Set<ConstraintViolation<InternetOrder>> constraintViolations = validator.validate(order);
        assertNull( order.getOrderId());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Enter an orderId", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testDelivery() {
        order.setDeliveryType(null);
        Set<ConstraintViolation<InternetOrder>> constraintViolations = validator.validate(order);
        assertNull( order.getDeliveryType());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Select a deliveryType", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testMark() {
        order.setFeedbackMark(6);
        Set<ConstraintViolation<InternetOrder>> constraintViolations = validator.validate(order);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Invalid value of mark", constraintViolations.iterator().next().getMessage());
    }
}