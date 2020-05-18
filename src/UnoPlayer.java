import java.util.ArrayList;
import java.util.Scanner;

/*
 * Vincent Horvath
 * 5/6/2020
 * This class will represent an Uno player with a hand of cards and 
 * contain actions for the player to make
 */

public class UnoPlayer {

	// Instance vars
	private String name;
	private ArrayList<UnoCard> hand;

	/*
	 * This method will create a new UnoPlayer with a given name
	 * 
	 * @param name the player name
	 */
	public UnoPlayer(String name) {
		this.name = name;
		hand = new ArrayList<UnoCard>();
	}

	/*
	 * Below are the setters and getters for each instance variable. Setters will
	 * set the value, getters will get it.
	 */
	public String getName() {
		return name;
	}

	public ArrayList<UnoCard> getHand() {
		return hand;
	}

	/*
	 * This method will add a card to the player's hand
	 * 
	 * @param card the card to add
	 */
	public void giveCard(UnoCard card) {
		hand.add(card);
	}

	/*
	 * This method will run a player's turn in the given UnoGame
	 * 
	 * @param game the UnoGame the player is in
	 */
	public void runTurn(UnoGame game) {
		Scanner sc = game.getScanner();

		// Draw if they dont have a valid card
		while (!hasCardFor(game.getLastPlayed())) {
			System.out.println("\n" + name + ", you do not have a valid card, press enter to draw");
			sc.nextLine();
			game.giveCards(this, 1);
		}

		// Play card
		UnoCard playing = null;
		do {
			// Display choices
			System.out.println("\n" + name + ", choose a valid card");
			System.out.println("\nA " + game.getLastPlayed().toString() + " was last played");
			for (int i = 0; i < hand.size(); ++i)
				System.out.println(i + 1 + "). " + hand.get(i).toString());

			// Get choice
			int choice = UsefulMethods.intInRange(1, hand.size(), sc);
			sc.nextLine();
			playing = hand.get(choice - 1);
		} while (!playing.isPlayableOn(game.getLastPlayed()));
		// Actually play card
		playing.play(game, this);
		game.setPlayed(playing);
		hand.remove(playing);

		// Announce "Uno"
		if (hand.size() == 1)
			System.out.println("\n" + name + ": \"Uno\"");
	}

	/*
	 * This method will return true if the player has any cards that are playable on
	 * a card
	 * 
	 * @param card the card to compare the player's hand too
	 * 
	 * @return true if the player can play that card
	 */
	public boolean hasCardFor(UnoCard card) {
		for (UnoCard handCard : hand)
			if (handCard.isPlayableOn(card))
				return true;
		return false;
	}
}
