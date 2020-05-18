/*
 * Vincent Horvath
 * 5/5/2020
 * This class will represent a base for all Uno cards
 */

public abstract class UnoCard {

	// Instance vars
	private String color;

	/*
	 * Below are the setters and getters for each instance variable. Setters will
	 * set the value, getters will get it.
	 */
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// This method will return true if this card is playable on another card
	public abstract boolean isPlayableOn(UnoCard card);

	/*
	 * This method will return an array of all card colors
	 * 
	 * @return an array of all uno colors
	 */
	public static String[] getColors() {
		String[] colors = { "Red", "Green", "Blue", "Yellow" };
		return colors;
	}

	// this method will play a card on an uno game for an UnoPlayer
	public abstract void play(UnoGame game, UnoPlayer player);

	// This method will represent a card as a String
	public abstract String toString();
}
