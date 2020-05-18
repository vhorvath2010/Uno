/*Vincent Horvath
  10/22/2019
  This program will contain all of my useful methods*/

import java.util.Scanner;

public class UsefulMethods {
	/*
	 * This method will be used to get an int within a range
	 * 
	 * @param lb an int, the lower bound of the range, inclusive.
	 * 
	 * @param ub an int, the upper bound of the range, inclusive.
	 * 
	 * @param sc the Scanner
	 * 
	 * @return a integer within that range
	 */
	public static int intInRange(int lb, int ub, Scanner sc) {
		int i = sc.nextInt();
		while (i < lb || i > ub) {
			System.out.print("\tThe number must be between " + lb + " and " + ub + " inclusive: ");
			i = sc.nextInt();
		}
		return i;
	}

	/*
	 * This method will get a positive integer
	 * 
	 * @param sc the Scanner
	 * 
	 * @return a positive int
	 */
	public static int positiveInt(Scanner sc) {
		int i = sc.nextInt();
		while (i < 0) {
			System.out.print("\tThe number must be positive: ");
			i = sc.nextInt();
		}
		return i;
	}

	/*
	 * This method will be used to get an double within a range
	 * 
	 * @param lb a double, the lower bound of the range, inclusive.
	 * 
	 * @param ub a double, the upper bound of the range, inclusive.
	 * 
	 * @param sc the Scanner
	 * 
	 * @return a integer within that range
	 */
	public static double doubleInRange(double lb, double ub, Scanner sc) {
		double n = sc.nextDouble();
		while (n < lb || n > ub) {
			System.out.print("\tThe number must be within " + lb + " and " + ub + " inclusive: ");
			n = sc.nextDouble();
		}
		return n;
	}

	/*
	 * This method will get a positive double
	 * 
	 * @param sc the Scanner
	 * 
	 * @return a positive double
	 */
	public static double positiveDouble(Scanner sc) {
		double i = sc.nextDouble();
		while (i < 0) {
			System.out.print("\tThe number must be positive: ");
			i = sc.nextDouble();
		}
		return i;
	}

	/*
	 * This method will get a yes or no response from the user
	 * 
	 * @param sc the Scanner
	 * 
	 * @return a yes or no answer as a String
	 */
	public static String yesOrNo(Scanner sc) {
		String response = sc.nextLine();
		while (!response.equalsIgnoreCase("no") && !response.equalsIgnoreCase("yes")) {
			System.out.print("\tYou must enter yes or no: ");
			response = sc.nextLine();
		}
		return response;
	}

	/*
	 * This method will get a non empty string
	 * 
	 * @param sc the Scanner
	 * 
	 * @return a non empty String
	 */
	public static String nonEmpty(Scanner sc) {
		String s = sc.nextLine();
		while (s.isEmpty()) {
			System.out.print("\tERROR, you must enter something: ");
			s = sc.nextLine();
		}
		return s;
	}

}