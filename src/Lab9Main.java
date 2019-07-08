import java.util.*;

public class Lab9Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean checkout = true;

		Map<String, Double> items = new HashMap<>();
		items.put("apples", 1.49);
		items.put("bananas", 5.00);
		items.put("papayas", 1.29);
		items.put("elderberries", 0.99);
		items.put("coconuts", 2.05);
		items.put("lemons", 0.89);
		items.put("garlic", 1.19);
		items.put("cilantro", 0.75);

		ArrayList<String> itemNames = new ArrayList<>();
		ArrayList<Double> itemPrices = new ArrayList<>();
		ArrayList<Integer> quantity = new ArrayList<>();

		for (Map.Entry<String, Double> item : items.entrySet()) {
			itemNames.add(item.getKey());
			itemPrices.add(item.getValue());
			quantity.add(0);
		}
		System.out.println("\nWelcome to Monsters of Freshness Market!\n");

		do {
			Lab9Methods.listItems(items);
			int userInput = Lab9Methods.getItem(scan, items, itemNames, itemPrices);
			Lab9Methods.getQuantity(scan, quantity, userInput);
			checkout = Lab9Methods.keepGoing(scan);
		} while (checkout);

		Lab9Methods.showCart(itemNames, itemPrices, quantity);
		double total = Lab9Methods.getTotal(itemNames, itemPrices, quantity);
		Lab9Methods.getAverage(itemPrices, quantity, total);
		int highIndex = Lab9Methods.highestCost(itemNames, itemPrices, quantity);
		Lab9Methods.lowestCost(itemNames, itemPrices, quantity, highIndex);
	}
}