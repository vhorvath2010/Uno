/*
 * Vincent Horvath
 * 5/6/2020
 * This class will represent a colored card with an action
 */
public class ActionCard extends UnoCard {

	// Instance vars
	private CardAction action;

	/*
	 * This method will construct an ActionCard
	 * 
	 * @param color the color
	 * 
	 * @param action the action
	 */
	public ActionCard(String color, CardAction action) {
		setColor(color);
		this.action = action;
	}

	/*
	 * Below are the setters and getters for each instance variable. Setters will
	 * set the value, getters will get it.
	 */
	public CardAction getAction() {
		return action;
	}

	/*
	 * This method will return true if this card is playable on another card
	 * 
	 * @param card the card to compare to
	 * 
	 * @return true if the cards are playable
	 */
	public boolean isPlayableOn(UnoCard card) {
		// Good if same color or action type
		if (card.getColor().equalsIgnoreCase(getColor()))
			return true;
		if (card instanceof ActionCard && ((ActionCard) card).getAction() == action)
			return true;
		// False otherwise
		return false;
	}

	/*
	 * This method will play an Action card on a game, doing the proper action
	 * 
	 * @param game the game
	 * 
	 * @param player the player who played the card
	 */
	public void play(UnoGame game, UnoPlayer player) {
		game.setPlayed(this);
		System.out.println("\n" + player.getName() + " played a " + toString());
		// Do proper action
		if (action == CardAction.DRAW_FOUR)
			game.giveCards(game.getNextPlayer(), 4);
		else if (action == CardAction.DRAW_TWO)
			game.giveCards(game.getNextPlayer(), 2);
		else if (action == CardAction.REVERSE)
			game.toggleReversed();
		else if (action == CardAction.SKIP)
			game.advanceCurrPlayer();
	}

	// This method will represent the card as a String
	public String toString() {
		return getColor() + " " + action.getTitle();
	}
}
