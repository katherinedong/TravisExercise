package discount;

import java.util.Random;

public class RandomDiscountStrategy
  implements DiscountStrategy {

  private Random rng;
  private float randomNumber;

  public RandomDiscountStrategy() {
    this.rng = new Random();
  }

  public float getRandomNumber() {
	  return randomNumber;
  }

  public float applyDiscount(Order order) {
	randomNumber = rng.nextFloat();
    return order.getPrice() * randomNumber;
  }
}
