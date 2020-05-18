import java.util.ArrayList;
import java.util.Scanner;

/*
 * Vincent Horvath
 * 5/6/2020
 * This class will represent a game of Uno. There will be a deck and player
 * manipulation in this class
 */

public class UnoGame {

	// Instance vars
	private UnoDeck deck;
	private ArrayList<UnoPlayer> players;
	private ArrayList<UnoCard> played;
	private boolean reverse;
	private Scanner sc;
	private int currentPlayer;

	/*
	 * This method will start a new UnoGame with a given number of players
	 * 
	 * @param numPlayers the number of players
	 */
	public UnoGame(int numPlayers) {
		// Init scanner and played cards list
		sc = new Scanner(System.in);
		played = new ArrayList<UnoCard>();

		// Create deck and add all players
		deck = new UnoDeck();
		players = new ArrayList<UnoPlayer>();
		for (int i = 0; i < numPlayers; ++i) {
			// Create new player to add
			System.out.print("Enter the name for player " + (i + 1) + ": ");
			// Give starting hand and register
			UnoPlayer player = new UnoPlayer(sc.nextLine());
			giveCards(player, 7);
			players.add(player);
		}

		// Add initial card
		played.add(deck.draw());

		// Start "first" turn
		nextTurn();
	}

	// Setters and getters
	public void setPlayed(UnoCard card) {
		played.add(card);
	}

	public UnoPlayer getNextPlayer() {
		// Calculate next player
		int change = 1;
		if (reverse)
			change = -1;
		int next = currentPlayer;
		next += change;
		next %= players.size();
		return players.get(next);
	}

	public void toggleReversed() {
		reverse = !reverse;
	}

	public Scanner getScanner() {
		return sc;
	}

	/*
	 * This method will get the last played card
	 * 
	 * @return the last played card
	 */
	public UnoCard getLastPlayed() {
		return played.get(played.size() - 1);
	}

	/*
	 * This method will give a certain number of cards to a player from the deck
	 * 
	 * @param player the player
	 */
	public void giveCards(UnoPlayer player, int num) {
		for (int i = 0; i < num; ++i) {
			// Make sure there is a card to give
			if (deck.isEmpty())
				// Add all except the last card to the deck
				for (int j = 0; j < played.size() - 1; ++j)
					deck.addCard(played.remove(0));

			// Give card
			player.giveCard(deck.draw());
		}
	}

	// This method will start the turn of the next player
	public void nextTurn() {
		// Get player and do their turn
		UnoPlayer player = players.get(currentPlayer);
		player.runTurn(this);

		// Update next player
		advanceCurrPlayer();
	}

	// This method will advance the current player 1
	public void advanceCurrPlayer() {
		// account for reverse
		if (reverse && currentPlayer == 0) {
			currentPlayer = players.size() - 1;
			return;
		}
		int change = 1;
		if (reverse)
			change = -1;
		currentPlayer += change;
		currentPlayer %= players.size();
	}

	/*
	 * This method will attempt to get a winner, it will return null if there is
	 * none
	 * 
	 * @return the winner if there is one, null otherwise
	 */
	public UnoPlayer getWinner() {
		for (UnoPlayer player : players) {
			if (player.getHand().size() == 0)
				return player;
		}
		return null;
	}
}
