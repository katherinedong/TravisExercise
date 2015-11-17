package test;

import static org.junit.Assert.*;
import discount.Demo;
import discount.Order;
import discount.PercentDiscountStrategy;
import discount.StoreCreditDiscountStrategy;

import org.junit.Test;

public class DiscountTest {
	
	@Test(expected = RuntimeException.class)
	public void testDefaultError() {
		String[] array = new String[2];
		array[0] = "5";
		array[1] = "5";
		Demo.main(array);
	}
	
	@Test
	public void testPercentDiscount() {
		Order order = new Order("Shane", 444.0f);
		PercentDiscountStrategy pds = new PercentDiscountStrategy(20.0f);
		float discountPrice = pds.applyDiscount(order);
		assertEquals(355.2f, discountPrice, 0.0f);
	
	}
	
	@Test
	public void testStoreCredit(){
		Order order = new Order("Shane",444.0f);
		StoreCreditDiscountStrategy scds = new StoreCreditDiscountStrategy(2.0f);
		float discountPrice = scds.applyDiscount(order);
		assertEquals(442.0f, discountPrice, 0.0f);
	}
	
//	@Test
//	public void testRandomDiscount() {
//		Order order = new Order("Shane",444.0f);
//		RandomDiscountStrategy rds = new RandomDiscountStrategy();
//		float discountPrice = rds.applyDiscount(order);
//		float expectedPrice = 444.0f * rds.getRng().nextFloat();
//		assertEquals(expectedPrice, discountPrice, 0.0f);
//	}
	

}
