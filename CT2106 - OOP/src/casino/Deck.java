package casino;

public class Deck {

	private Card[] cards = null; 
	
	/*
	 * public Constructor with arguments.
	 */
	public Deck() {
		//TODO initialise the cards array (size 52)
		//then insert a new unique (and valid) Card for each of the array slots
		//Your deck can't include duplicates
		cards = new Card[52];
		int y;
		int x;
		int i=0;
		
		for (y=0;y<4;y++){
			for(x=1;x<=13;x++){
				cards[i] = new Card(y,x);//adding values into the array
				cards[i].getSuit();//getting getSuit
				cards[i].getRank();//getting getRank
				i++;
			}
		}
	} 
/*
 * for loop for adding 52 cards into object cards from array String[] suit and String[] rank
 */
	
	/*
	 * returns a String representation of the array of Card
	 * e.g Ace of Clubs, Two of Clubs, Three of Clubs,..
	 */
	public String toString(){
		//TODO
		return null;
	}/* similar to Card String toString so not implemented */
	
	
	/*
	 * This method shuffles the deck.
	 * There are many ways to do this
	 * One such way would be to select two random positions in the deck and swap the cards
	 * Then do this a number of times
	 */
	public void shuffle(){
		//TODO 
		//To get a random position in the deck you could use the math.random() function
		
		int i = 0;
		Card temp;//temperate Card object to hold card 
		for (i=0; i<52;i++)
		{
			int pos1 = (int)(Math.random()*52);//assigning random number from 0-51
			//to shuffle cards
			
			temp = cards[i];//sorting called bubble sort to shuffle the cards
			cards[i] = cards[pos1];
			cards[pos1] = temp;
			
		}
	}
	
	/*
	 * This method selects the top card from the Deck
	 * It then copies all the Cards (except the top Card) in the cards array into a new array 
	 * and then sets the cards variable to point to that array
	 * This has the effect of reducing the size of he deck by one every time this 
	 * method is called
	 * The method returns the Card selected in the first step
	 */
	
	public Card removeTopCard(){
		
		//TODO
		int t;
		Card topcard;
		Card[] cards2 = new Card[cards.length];//gets the new array size of cards.length
		topcard = cards[0];//topcard is initialised at index 1 (zeroeth)
		for (t=0; t<cards.length-1; t++)
		{
			cards2[t]=cards[t+1];//moves position up 
		}
		cards=cards2;//new cards without the topcard
		return topcard;
	}
	
}


