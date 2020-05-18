/*
 * Vincent Horvath
 * 5/6/2020
 * This class will represent a wild card in Uno
 */
public class WildCard extends ActionCard {

	/*
	 * This method will construct a wild card
	 * 
	 * @param action the action
	 */
	public WildCard(CardAction action) {
		super("Wild", action);
	}

	@Override
	public boolean isPlayableOn(UnoCard card) {
		return true;
	}

	/*
	 * This method will play an Action card on a game, doing the proper action
	 * 
	 * @param game the game
	 * 
	 * @param player the player who played the card
	 */
	public void play(UnoGame game, UnoPlayer player) {
		// Get color we're playing as
		String[] validColors = "Red Green Blue Yellow".split(" ");
		System.out.println("\nChoose a color for the wild card: ");
		for (int i = 0; i < validColors.length; ++i)
			System.out.println(i + 1 + "). " + validColors[i]);
		int choice = UsefulMethods.intInRange(1, validColors.length, game.getScanner());

		// Set color
		setColor(validColors[choice - 1]);

		super.play(game, player);
	}

}
