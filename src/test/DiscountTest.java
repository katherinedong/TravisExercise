package test;

import static org.junit.Assert.*;
import discount.Demo;
import discount.Order;
import discount.PercentDiscountStrategy;
import discount.RandomDiscountStrategy;
import discount.StoreCreditDiscountStrategy;

import org.junit.Test;

public class DiscountTest {
	
	@Test(expected = RuntimeException.class)
	public void testDefaultError() {
		String[] array = {"5","5"};
		Demo.main(array);
	}
	
	@Test
	public void testPercentDiscount() {
		Order order = new Order("Shane", 444.0f);
		PercentDiscountStrategy pds = new PercentDiscountStrategy(20.0f);
		float discountPrice = pds.applyDiscount(order);
		
		assertTrue(444.0f > discountPrice);
		assertEquals(355.2f, discountPrice, 0.0f);
	}
	
	@Test
	public void testStoreCredit(){
		Order order = new Order("Shane",444.0f);
		StoreCreditDiscountStrategy scds = new StoreCreditDiscountStrategy(2.0f);
		float discountPrice = scds.applyDiscount(order);
		
		assertTrue(444.0f > discountPrice);
		assertEquals(442.0f, discountPrice, 0.0f);
	}
	
	@Test
	public void testRandomDiscount() {
		Order order = new Order("Shane",444.0f);
		RandomDiscountStrategy rds = new RandomDiscountStrategy();
		float discountPrice = rds.applyDiscount(order);
		
		assertTrue(444.0f > discountPrice);
		
		float randomNumber = rds.getRandomNumber();
		float expectedPrice = 444.0f * randomNumber;
		assertEquals(expectedPrice, discountPrice, 0.0f);
	}
	

}
