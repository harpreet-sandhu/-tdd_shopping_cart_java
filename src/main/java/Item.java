
public class Item {
	private String name;
	private double currency;
	private boolean onSale;

	Item(String name, double currency, boolean onSale) {
		this.name = name;
		this.currency = currency;
		this.onSale = onSale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrency() {
		return currency;
	}

	public void setCurrency(double currency) {
		this.currency = currency;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	// @Override
	// public boolean equals(Object o) {
	// if((o instanceof Item) && ((Item)o).getName() == name)
	// return true;
	// return false;
	// }
	//
	// @Override
	// public int hashCode() {
	// return this.getName().hashCode();
	// }
}
