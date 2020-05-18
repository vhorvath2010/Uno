import java.util.ArrayList;
import java.util.Random;

/*
 * Vincent Horvath
 * 5/6/2020
 * This class will represent an Uno deck. The deck can be reset,
 * shuffled, and drawn from
 */

public class UnoDeck {

	// Instance vars
	private ArrayList<UnoCard> cards;

	// Create a new deck
	public UnoDeck() {
		// Create and shuffle deck
		initDeck();
		shuffle();
	}

	/*
	 * This method will add a card to the deck
	 * 
	 * @param card the card
	 */
	public void addCard(UnoCard card) {
		cards.add(card);
	}

	// This method will add all necessary cards to the deck
	private void initDeck() {
		// Create deck and add all cards
		cards = new ArrayList<UnoCard>();
		CardAction[] actions = CardAction.values();

		// Add colored cards
		for (String color : UnoCard.getColors()) {
			// Add numbered
			cards.add(new NumberedCard(color, 0));
			for (int i = 1; i < 10; ++i) {
				cards.add(new NumberedCard(color, i));
				cards.add(new NumberedCard(color, i));
			}

			// Add actions
			for (int i = 0; i < 3; ++i) {
				cards.add(new ActionCard(color, actions[i]));
				cards.add(new ActionCard(color, actions[i]));
			}
		}

		// Add wild cards
		for (int i = 0; i < 4; ++i) {
			cards.add(new WildCard(CardAction.NONE));
			cards.add(new WildCard(CardAction.DRAW_FOUR));
		}

	}

	// This method will shuffle the deck
	public void shuffle() {
		Random rg = new Random();
		// Create temp list for randomly picking
		@SuppressWarnings("unchecked")
		ArrayList<UnoCard> tempCards = (ArrayList<UnoCard>) cards.clone();

		// Clear list and start adding the cards back
		cards.clear();
		while (!tempCards.isEmpty())
			cards.add(tempCards.remove(rg.nextInt(tempCards.size())));
	}

	/*
	 * This method will get the card off the top of the deck
	 * 
	 * @return the next card
	 */
	public UnoCard draw() {
		if (cards.size() > 0)
			return cards.remove(0);
		return null;
	}

	/*
	 * This method will check if the deck is empty
	 * 
	 * @return true if the deck is empty
	 */
	public boolean isEmpty() {
		return cards.isEmpty();
	}

}
