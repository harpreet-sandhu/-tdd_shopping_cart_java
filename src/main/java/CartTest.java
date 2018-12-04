import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CartTest {

	private Cart cart;
	private Item iPad;
	private Item surfacePro;
	private Item galaxyTab;

	@Before
	public void setUp() throws Exception {
		cart = new Cart();
		iPad = new Item("iPad", 750.00, false);
		surfacePro = new Item("SurfacePro", 500.00, true);
		galaxyTab = new Item("GalaxyTab", 300.00, true);
	}

	@Test
	public void testGetItems() {
		// Exercise
		cart.addItem(iPad, 3);
		Map<Item, Integer> items = cart.getItems();

		// Assert
		assertEquals(1, items.size());

	}

	@Test
	public void testGetMultipleItems() {
		// Exercise
		cart.addItem(iPad, 3);
		cart.addItem(surfacePro, 3);
		Map<Item, Integer> items = cart.getItems();

		// Assert
		assertEquals(2, items.size());
	}

	@Test
	public void testAddItem() {
		// Exercise
		cart.addItem(iPad, 3);

		// Assert
		assertEquals(1, cart.getItems().size());
	}

	@Test
	public void testAddSameItemTwice() {
		// Exercise
		cart.addItem(iPad, 3);
		cart.addItem(iPad, 2);

		// Assert
		assertEquals(1, cart.getItems().size());
	}

	@Test
	public void testAddingTwoItem() {
		// Exercise
		cart.addItem(iPad, 3);
		cart.addItem(surfacePro, 3);

		// Assert
		assertEquals(2, cart.getItems().size());
	}

	@Test
	public void testItemizedList() {
		// Exercise
		cart.addItem(iPad, 2);
		String itemizedList = cart.itemizedList();

		// Assert
		assertEquals("iPad x2 - $1,500.00 ", itemizedList);
	}

	@Test
	public void testItemizedListTwoItems() {
		// Exercise
		cart.addItem(iPad, 2);
		cart.addItem(surfacePro, 3);
		String itemizedList = cart.itemizedList();

		// Assert
		assertEquals("iPad x2 - $1,500.00 SurfacePro x3 - $1,500.00 ", itemizedList);
	}

	@Test
	public void testItemQuantities() {
		// Exercise
		cart.addItem(iPad, 4);
		String itemQuantities = cart.itemQuantities();

		// Assert
		assertEquals("iPad - x4 ", itemQuantities);
	}
	
	@Test
	public void testItemQuantitiesTwoItems() {
		// Exercise
		cart.addItem(iPad, 4);
		cart.addItem(surfacePro, 4);
		String itemQuantities = cart.itemQuantities();

		// Assert
		assertEquals("iPad - x4 SurfacePro - x4 ", itemQuantities);
	}

	@Test
	public void testOnSaleItems() {
		// Exercise
		cart.addItem(iPad, 3);
		cart.addItem(surfacePro, 2);
		String saleItems = cart.onSaleItems();

		// Assert
		assertEquals("SurfacePro x2 - $1,000.00 ", saleItems);
	}
	
	@Test
	public void testOnSaleMultipleItems() {
		// Exercise
		cart.addItem(surfacePro, 3);
		cart.addItem(galaxyTab, 2);
		String saleItems = cart.onSaleItems();

		// Assert
		assertEquals("SurfacePro x3 - $1,500.00 GalaxyTab x2 - $600.00 ", saleItems);
	}

	@Test
	public void testGetTotalPrice() {
		// Exercise
		cart.addItem(iPad, 3);
		double price = cart.getTotalPrice();
		// Assert
		assertEquals(2250.00, price, 0.0001);
	}
	
	@Test
	public void testGetTotalPriceTwoItems() {
		// Exercise
		cart.addItem(iPad, 3);
		cart.addItem(surfacePro, 2);
		double price = cart.getTotalPrice();
		// Assert
		assertEquals(3250.00, price, 0.0001);
	}

}
