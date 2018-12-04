import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

	private Map<Item, Integer> items;
	private NumberFormat formatter = NumberFormat.getCurrencyInstance();

	public Cart() {
		this.items = new LinkedHashMap<Item, Integer>();
	}

	public Map<Item, Integer> getItems() {
		return items;
	}

	public void addItem(Item item, int quantity) {
		for (Map.Entry<Item, Integer> entry : items.entrySet()) {
			if (entry.getKey().getName() == item.getName()) {
				entry.setValue(entry.getValue() + quantity);
				return;
			}
		}
		items.put(item, quantity);
	}

	public String itemizedList() {
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<Item, Integer> entry : items.entrySet()) {
			sb.append(entry.getKey().getName() + " x" + entry.getValue() + " - "
					+ formatter.format(entry.getKey().getCurrency() * entry.getValue()) + " ");
		}
		return sb.toString();
	}

	public String itemQuantities() {
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<Item, Integer> entry : items.entrySet()) {
			sb.append(entry.getKey().getName() + " - x" + entry.getValue() + " ");
		}
		return sb.toString();
	}

	public String onSaleItems() {
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<Item, Integer> entry : items.entrySet()) {
			if (entry.getKey().isOnSale()) {
				sb.append(entry.getKey().getName() + " x" + entry.getValue() + " - "
						+ formatter.format(entry.getKey().getCurrency() * entry.getValue()) + " ");
			}
		}
		return sb.toString();
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (Map.Entry<Item, Integer> entry : items.entrySet()) {
			totalPrice += entry.getKey().getCurrency() * entry.getValue();
		}
		return totalPrice;
	}

}
