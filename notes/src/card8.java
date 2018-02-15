
public class card8 
{
	
	
	public enum  Card
	{
		ACE_CLUBS, TWO_CLUBS, THREE_CLUBS, FOUR_CLUBS, FIVE_CLUBS, SIX_CLUBS, SEVEN_CLUBS, 
		EIGHT_CLUBS, NINE_CLUBS, TEN_CLUBS, JACK_CLUBS, QUEEN_CLUBS, KING_CLUBS, 
		ACE_DIAMONDS, TWO_DIAMONDS, THREE_DIAMONDS;
		
		public enum Rank 
		{
			ACE, TWO, THREE, FOUR, FIVE, SIX,
			SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
		}
		
		
		public Rank getRank() 
		{
			
			
			return Rank.values()[this.ordinal() % Rank.values().length];
	
		}
		
		
		
	}
	

	

}
