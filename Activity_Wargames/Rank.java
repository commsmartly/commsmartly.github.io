/**
 * Lesson 21: Activity - Deck of Cards
 * 
 * Represents the ranks of standard playing cards.
 * 
 * @author Mike Taylor
 * @version Fall 2020
 */
public enum Rank
{
	Two(2),
	Three(3),
	Four(4),
	Five(5),
	Six(6),
	Seven(7),
	Eight(8),
	Nine(9),
	Ten(10),
	Jack(11),
	Queen(12),
	King(13),
	Ace(14);

	private int rank;

	private Rank(int rank) {
		this.rank = rank;
	}

	public int getFaceValue() {
		return rank;
	}
}