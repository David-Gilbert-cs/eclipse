import java.io.ObjectInputStream.GetField;

public class Card7
{
	/**
 	 * A card's rank.
	 */
	public enum Rank 
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING,JOKER;
	}
	
	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS, DIAMONDS, SPADES, HEARTS, NULL ;
			
		enum Color
		{
			RED, BLACK;
		}
			
		public Color getColor()
		{
			if( this == CLUBS || this == SPADES )
			{
				return Color.BLACK;
			}
			else
			{
				return Color.RED;
			}
		}
			
		public String toString()
		{
			return name().substring(0,1) + name().substring(1, name().length()).toLowerCase();
		}
	}
	
	public static final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	private Rank aRank; // Invariant: != null
	private Suit aSuit; // Invariant: != null
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null && pSuit != null
	 */
	public Card7(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 * @post return != null
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 * @post return != null
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	/**
	 * Assigns a new rank to the card.
	 * @param pRank The new rank.
	 * @pre pRank != null
	 */
	public void setRank(Rank pRank)
	{
		aRank = pRank;
	}
	
	/**
	 * Assigns a new suit to the card.
	 * @param pSuit The new suit.
	 * @pre pSuit != null
	 */
	public void setSuit(Suit pSuit)
	{
		aSuit = pSuit;
	}
	
	@Override
	public String toString()
	{
		return aRank + " of " + aSuit;
	}
}