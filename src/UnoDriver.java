import java.util.Scanner;

/*
 * Vincent Horvath
 * 5/6/2020
 * This program will act as the driver for the UnoProgram
 */

public class UnoDriver {

	public static void main(String[] args) {
		// Create Uno game
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of players: ");
		UnoGame game = new UnoGame(UsefulMethods.intInRange(1, 4, in));

		// Play until winner
		while (game.getWinner() == null) {
			game.nextTurn();
		}

		System.out.println("\n\nThe winner is " + game.getWinner().getName() + "!");
	}

}
