package casino;

public class Dealer {
	
	private Deck deck;
	

	public static void main(String[] args) {
	
		int cards_In_Hand = Integer.parseInt(args[0]); // number of card in each hand
		int numHands = Integer.parseInt(args[1]);  // number of hands
		
		Hand[] hands = new Hand[numHands]; // create an array to hold the number of hands required
		
		Dealer dealer = new Dealer(); // new Dealer object
		dealer.newDeck(); // creates a new Deck
		dealer.shuffle(); // then shuffles the Deck
		
		
		for (int i = 0; i< hands.length; i++){ // for the number of hands required
			Hand hand = dealer.deal(cards_In_Hand); // create a new  hand
			hands[i]=hand; // store each hand in the array
		}
		
		
		for (int i = 0; i< hands.length; i++){ // for each of the hands
			hands[i].show(); // print out the cards in each hand
		}//called hands.lenght times to print 
		
		//you can error check if you would multiply the cards_In_Hand and numHands
		//and if they are > 52 break out of the loop saying too many cards requested
		/*sample code
		 * int check = cards_In_hand*numHands;
		 * if (check>52)
		 * {
		 * 	System.out.println("Too many cards requested");
		 * break;
		 * }
		 */
	}

	
	/*
	 * This method removes n cards from the top of the deck and inserts them one by one into a new Hand object
	 * which is then returned
	 * 
	 */

	public Hand deal(int n) {
		// TODO write the code to deal out n cards from the deck
		// You will need to create a Hand object and add these cards to it.
		Hand  temphand = new Hand(n);
		int q=0;
		while(q<n)
		{
			Card cards2 = deck.removeTopCard();
			temphand.addCard(cards2, q);
			q++;
		}
		return temphand;
	}


	/*
	 * This method calls the shuffle method of the deck object
	 * 
	 */
	
	public void shuffle() {
		deck.shuffle();

	}

	
	/*
	 * This method creates a new Deck object and assigns it to the variable deck
	 */

	public void newDeck() {
		deck= new Deck();
		
	}

}
