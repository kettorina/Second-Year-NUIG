package casino;

public class Hand {
	
	private Card[] cards;

	
	
	
	public Hand(int n){
		
		//TODO you will need to initialize the cards variable with an array of size n
		cards = new Card[n];
		
	}
	
	
	/*
	 * This method adds a Card to the cards array
	 */
	
	public void addCard(Card card, int i){
		//TODO you need to insert a Card to the array
		//You'll need to have kept track of how many cards have been added already
		//so that you add the card in the right place (i.e. immediately after the last added one)
		cards[i] = card;
	}
	
	/*
	 * This method prints out the hand
	 * e.g. Ace of Clubs, 3 of Diamonds, Jack of Hearts, etc
	 */
	
	public void show() {
		// TODO Auto-generated method stub
		int i;
		
		System.out.print("Hand: ");
		for (i=0;i<cards.length;i++)//loops for the size of hand
		{
			if (!cards[i].equals(cards[i])){
				System.out.println("Error");
				break;
			}
			
			System.out.print(cards[i].toString()+", ");//prints out cards in hand
			
		}
		System.out.println(" ");
	}
}