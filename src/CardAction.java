/*
 * Vincent Horvath
 * 5/6/2020
 * This enum will hold all the actions for action cards
 */
public enum CardAction {
	DRAW_TWO("Draw Two"), SKIP("Skip"), REVERSE("Reverse"), DRAW_FOUR("Draw Four"), NONE("Card");

	private String title;

	private CardAction(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
