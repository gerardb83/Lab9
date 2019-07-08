import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Lab9Methods {
	public static DecimalFormat df = new DecimalFormat("0.00");

	public static void listItems(Map<String, Double> items) {
		int i = 0;
		System.out.printf("%-23s %-4s\n", "Item", "Price");
		System.out.printf("=============================\n");
		while (i < items.size()) {
			for (Map.Entry<String, Double> item : items.entrySet()) {
				System.out.printf("%-16s %-5s\n", i + 1 + ". " + item.getKey(), "\t$" + df.format(item.getValue()));
				i++;
			}
		}
	}

	public static int getItem(Scanner scan, Map<String, Double> items, ArrayList<String> item,
			ArrayList<Double> price) {
		String prompt = "\nWhat item would you like to order? (enter number): ";
		String rangeString = "Number must be between 1 and 8.";
		int userInput = ValidationMethods.getRangeInt(scan, prompt, 1, 8, rangeString);
		userInput -= 1;
		String userItem = item.get(userInput);
		System.out.printf("Adding " + userItem + " to the cart at $" + df.format(price.get(userInput)) + " each.\n");
		return userInput;
	}

	public static void getQuantity(Scanner scan, ArrayList<Integer> quantity, int userInput) {
		int userQuantity = ValidationMethods.getPositiveInt(scan, "Please enter the quantity of this item: ");
		quantity.set(userInput, quantity.get(userInput) + userQuantity);
		System.out.println(userQuantity + " added!");
	}

	public static boolean keepGoing(Scanner scan) {
		boolean checkout = true;
		String prompt = "To add more items, enter 'y', to go to checkout, enter 'n': ";
		String answer = ValidationMethods.getString(scan, prompt);
		if (answer.equalsIgnoreCase("n")) {
			checkout = false;
		}
		return checkout;
	}

	public static void showCart(ArrayList<String> itemNames, ArrayList<Double> itemPrices,
			ArrayList<Integer> quantity) {
		System.out.println("Thanks for your order!\nHere's what you got: ");
		System.out.printf("%-13s %-12s %-5s\n", "Item", "Price", "Quantity");
		System.out.printf("=====================================\n");
		for (int i = 0; i < itemNames.size(); i++) {
			System.out.printf("%-13s %-12s %-5s\n", itemNames.get(i), "$" + df.format(itemPrices.get(i)),
					quantity.get(i));
		}
	}

	public static double getTotal(ArrayList<String> itemNames, ArrayList<Double> itemPrices,
			ArrayList<Integer> quantity) {
		double total = 0;
		for (int i = 0; i < itemPrices.size(); i++) {
			total += itemPrices.get(i) * quantity.get(i);
		}
		System.out.println("Cart Total: $" + df.format(total));
		return total;
	}

	public static void getAverage(ArrayList<Double> itemPrices, ArrayList<Integer> quantity, double total) {
		double average = 0;
		int quantityTotal = 0;
		for (int numItem : quantity) {
			quantityTotal += numItem;
		}
		average = total / quantityTotal;
		System.out.println("Average cost per item: $" + df.format(average));
	}

	public static int highestCost(ArrayList<String> itemNames, ArrayList<Double> itemPrices,
			ArrayList<Integer> quantity) {
		double highPrice = 0;
		int highIndex = 0;
		String highItem = "";
		for (int i = 0; i < itemPrices.size(); i++) {
			if (quantity.get(i) > 0) {
				if (itemPrices.get(i) > highPrice) {
					highPrice = itemPrices.get(i);
					highItem = itemNames.get(i);
					highIndex = i;
				}
			}
		}
		System.out.println("Highest price item: " + highItem + " at $" + df.format(highPrice) + " each.");
		return highIndex;
	}

	public static void lowestCost(ArrayList<String> itemNames, ArrayList<Double> itemPrices,
			ArrayList<Integer> quantity, int highIndex) {
		double lowPrice = itemPrices.get(highIndex);
		String lowItem = itemNames.get(highIndex);
		for (int i = 0; i < itemPrices.size(); i++) {
			if (quantity.get(i) > 0) {
				if (itemPrices.get(i) < lowPrice) {
					lowPrice = itemPrices.get(i);
					lowItem = itemNames.get(i);
				}
			}
		}
		System.out.println("Lowest price item: " + lowItem + " at $" + df.format(lowPrice) + " each.");
	}
}
