package main;

class Fruit {
	String name;
	int quantity;
	float price;

	Fruit(String name, int quantity, float price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setQuantity(int q) {
		quantity = q;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getPrice() {
		return price;
	}
}


