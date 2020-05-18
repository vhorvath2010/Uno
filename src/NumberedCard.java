/*
 * Vincent Horvath 
 * This class wil represent a numbered uno card
 * 5/5/2020
 */
public class NumberedCard extends UnoCard {

	// Instance vars
	private int num;

	/*
	 * This constructor will create a numbered Uno card
	 * 
	 * @param num the num
	 * 
	 * @param color the color
	 */
	public NumberedCard(String color, int num) {
		setNum(num);
		setColor(color);
	}

	/*
	 * Below are the setters and getters for each instance variable. Setters will
	 * set the value, getters will get it.
	 */
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	/*
	 * This method will return true if this card is playable on another card
	 * 
	 * @param card the card to compare to
	 * 
	 * @return true if the cards are playable
	 */
	public boolean isPlayableOn(UnoCard card) {
		// True if same color
		if (card.getColor().equalsIgnoreCase(getColor()))
			return true;
		// True if same number
		if (card instanceof NumberedCard && ((NumberedCard) card).getNum() == num)
			return true;
		// False otherwise
		return false;
	}

	/*
	 * This method will play an Uno card on a game
	 * 
	 * @param game the game
	 * 
	 * @param player the player
	 */
	public void play(UnoGame game, UnoPlayer player) {
		game.setPlayed(this);
		System.out.println("\n" + player.getName() + " played a " + toString());
	}

	// This method will represent the card as a String
	public String toString() {
		return getColor() + " " + num;
	}

}
