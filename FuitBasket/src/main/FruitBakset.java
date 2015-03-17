package main;

import java.util.ArrayList;
import java.util.Scanner;

public class FruitBakset {
	private static final String YES = "yes";
	
	private static String nameOfFruit;
	private static int quantityOfFruit;
	private static boolean chooseAnotherFruit = true;
	
	private ArrayList<Fruit> cart;
	private Scanner inputFromUser;

	public static void main(String[] args) {

		FruitBakset fruitBasket = new FruitBakset();
		fruitBasket.gatherFruit();
		
	}

	private void gatherFruit() {
		float totalPrice = 0.00f;

		cart = new ArrayList<Fruit>();
		inputFromUser = new Scanner(System.in);

		chooseFruitAndQuantity();
		removeDuplicateFromCart();
		printOutBasket(totalPrice);
	}

	public void gatherFruit(String name, int quantity, boolean bol) {
		// float totalPrice = 0.00f;

		cart = new ArrayList<Fruit>();
		inputFromUser = new Scanner(System.in);

		chooseFruitAndQuantity(name, quantity, bol);
		// removeDuplicateFromCart();
		// printOutBasket(totalPrice);
	}

	private void chooseFruitAndQuantity() {
		//String nameOfFruit;
		//int quantityOfFruit;
		//boolean chooseAnotherFruit = true;

		while (chooseAnotherFruit) {
			nameOfFruit = selectFruit();
			boolean picksAFruit = checkIfUserPicksAFruit(nameOfFruit);
			if (picksAFruit) {
				quantityOfFruit = setAmountOfFruit(nameOfFruit);
				createFruitObject(nameOfFruit, quantityOfFruit);
				chooseAnotherFruit = pickAnotherFruitOption();
			} else
				pickFruitAgain();
		}
	}

	public void chooseFruitAndQuantity(String name, int quantity, boolean bol) {
		//String nameOfFruit;
		//int quantityOfFruit;
		//boolean chooseAnotherFruit = true;

		while (chooseAnotherFruit) {
			nameOfFruit = selectFruit(name);
			boolean picksAFruit = checkIfUserPicksAFruit(nameOfFruit);
			if (picksAFruit) {
				quantityOfFruit = setAmountOfFruit(quantity);
				createFruitObject(nameOfFruit, quantityOfFruit);
				chooseAnotherFruit = pickAnotherFruitOption(bol);
			} else
				pickFruitAgain();
		}
	}

	private String selectFruit() {
		String name;
		System.out.println("What fruit would you like? Your choices are: "
				+ AvailableFruit.printList());
		name = "";
		name = inputFromUser.next();
		return name;
	}

	public String selectFruit(String nameOfFruit) {
		return nameOfFruit;
	}

	public boolean checkIfUserPicksAFruit(String nameOfFruit) {
		if (AvailableFruit.lookUp(nameOfFruit) != null) {
			return true;
		}
		return false;
	}

	private int setAmountOfFruit(String nameOfFruit) {
		int quantity;
		System.out.println("How many " + nameOfFruit + "s would you like?");
		quantity = 0;
		quantity = inputFromUser.nextInt();
		return quantity;
	}

	public int setAmountOfFruit(int quantity) {
		return quantity;
	}

	public void createFruitObject(String nameOfFruit, int quantityOfFruit) {
		switch (nameOfFruit) {
		case "apple":
			cart.add(new Fruit(nameOfFruit, quantityOfFruit, 0.75f));
			break;
		case "orange":
			cart.add(new Fruit(nameOfFruit, quantityOfFruit, 0.50f));
			break;
		case "banana":
			cart.add(new Fruit(nameOfFruit, quantityOfFruit, 0.25f));
			break;
		}
	}

	private boolean pickAnotherFruitOption() {
		String another;
		System.out
				.println("Do you want to add another fruit to your cart? Type yes or no.");
		another = inputFromUser.next().toLowerCase();
		return another.equals(YES);
	}

	public boolean pickAnotherFruitOption(boolean bol) {
		return bol;
	}

	public void pickFruitAgain() {
		System.out
				.println("You did not type the name of a fruit offered. Please try agian.");
	}

	public void removeDuplicateFromCart() {
		for (int j = 0; j < cart.size(); j++) {

			String nameOfFruit = cart.get(j).getName();
			checkAndRemoveSecondFruit(j, nameOfFruit);
		}
	}

	private void checkAndRemoveSecondFruit(int j, String nameOfFruit) {
		for (int sj = j + 1; sj < cart.size(); sj++) {
			if (((cart.get(sj)).getName().contains(nameOfFruit))) {
				addDuplicateFruitQuantities(j, sj);
				cart.remove(sj);
				sj--;
			}
		}
	}

	private void addDuplicateFruitQuantities(int j, int sj) {
		cart.get(j).setQuantity(
				cart.get(j).getQuantity() + cart.get(sj).getQuantity());
	}

	public void printOutBasket(float totalPrice) {
		// total price and put in different method
		float subTotal;
		for (int i = 0; i < cart.size(); i++) {
			System.out.println(cart.get(i).getQuantity() + "   "
					+ cart.get(i).getName() + "\t@ $" + cart.get(i).getPrice()
					+ " each");
			subTotal = cart.get(i).getPrice() * cart.get(i).getQuantity();

			totalPrice = totalPrice + subTotal;
		}
		System.out.println("Your total is:" + totalPrice);
	}
	
	public static void setNameOfFruit(String nameOfFruit) {
		FruitBakset.nameOfFruit = nameOfFruit;
	}

	public static void setChooseAnotherFruit(boolean chooseAnotherFruit) {
		FruitBakset.chooseAnotherFruit = chooseAnotherFruit;
	}

	public static void setQuantityOfFruit(int quantityOfFruit) {
		FruitBakset.quantityOfFruit = quantityOfFruit;
	}

	enum AvailableFruit {
		APPLE(), BANANA(), ORANGE();

		static AvailableFruit lookUp(String fruit) {
			for (AvailableFruit value : values()) {
				if (value.name().equalsIgnoreCase(fruit)) {
					return value;
				}
			}
			return null;
		}

		static String printList() {
			String list = "";
			for (AvailableFruit value : values()) {
				list += value.name() + " ";
			}
			return list;
		}
	}

}