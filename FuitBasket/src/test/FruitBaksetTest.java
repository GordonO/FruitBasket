package test;

import static org.junit.Assert.*;
import main.FruitBakset;

import org.junit.Before;
import org.junit.Test;

public class FruitBaksetTest {

	FruitBakset fruitBakset = null;
	static String name = "";
	static int quantity = 0;
	static boolean another = true;

	@Before
	public void initialize() {
		fruitBakset = new FruitBakset();

//		fruitBakset.gatherFruit(name, quantity, another);
	}

	@Test
	public void shouldreturnAppleQuantityZeroPriceZeroForInputAppleQuantityZero() {
//		fruitBakset.setNameOfFruit("apple");
//		fruitBakset.setQuantityOfFruit(0);
//		fruitBakset.setChooseAnotherFruit(false);
		
		name = "apple";
		quantity = 1;
		another = false;
		
		fruitBakset.gatherFruit(name, quantity, another);
	}

	// private <T> void assertValues(String name, int quantity, String another)
	// {
	//
	// }
}
