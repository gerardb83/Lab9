
import java.util.Map;
import java.util.Scanner;

public class ValidationMethods {

	public static double getPositiveDouble(Scanner scnr, String prompt) {
		System.out.println(prompt);

		double answer;
		do {
			while (!scnr.hasNextDouble()) {
				scnr.nextLine();
				System.out.println("This is not a valid number.");
				System.out.println(prompt);
			}
			answer = scnr.nextDouble();
			scnr.nextLine();
			if (answer < 0.0) {
				System.out.println("The number must be 0 or greater.");
			}
		} while (answer < 0.0);
		return answer;
	}

	public static int getPositiveInt(Scanner scnr, String prompt) {
		System.out.println(prompt);
		int answer;
		do {
			while (!scnr.hasNextInt()) {
				scnr.nextLine();
				System.out.println("This is not a valid number.");
				System.out.println(prompt);
			}
			answer = scnr.nextInt();
			scnr.nextLine();

			if (answer < 0) {
				System.out.println("The number must be 0 or greater.");
				System.out.println(prompt);
			}
		} while (answer < 0);
		return answer;
	}

	public static int getRangeInt(Scanner scnr, String prompt, int lowRange, int highRange, String rangeString) {
		System.out.println(prompt);
		int answer;
		do {
			while (!scnr.hasNextInt()) {
				scnr.nextLine();
				System.out.println("This is not a valid number.");
				System.out.println(prompt);
			}
			answer = scnr.nextInt();
			scnr.nextLine();
			if (answer < lowRange || answer > highRange) {
				System.out.println(rangeString);
				System.out.println(prompt);
			}
		} while (answer < lowRange || answer > highRange);
		return answer;
	}

	public static String getString(Scanner scnr, String prompt) {
		System.out.println(prompt);
		String tempString = "";
		String answer = "";
		do {
			while (!scnr.hasNextLine()) {
				System.out.println("This is not a valid entry.");
				System.out.println(prompt);
			}
			tempString = scnr.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
			if (tempString.equals("y") || tempString.equals("n")) {
				answer = tempString;
			} else {
				System.out.println("Sorry, I didn't understand.");
				System.out.println(prompt);
			}
		} while (answer.equals(""));
		return answer;
	}

	public static String matchString(Scanner scnr, String prompt, Map<String, Double> items) {
		System.out.print(prompt);
		String tempString;
		String answer = "";
		do {
			while (!scnr.hasNextLine()) {
				System.out.println("This is not a valid entry.");
				System.out.println(prompt);
			}
			tempString = scnr.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
			if (items.containsKey(tempString)) {
				answer = tempString;
			} else {
				System.out.print("Sorry, we don't carry that item. Please try again: ");
			}
		} while (answer.equals(""));
		return answer;
	}
}
