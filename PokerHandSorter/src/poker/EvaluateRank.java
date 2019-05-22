/* Java Class to Evaluate Rank for each player in Poker.
 * This class defines method to evaluate rank by taking array of cards in a hand 
 * as input and rank as output. Also this class is using selection sort algorithm
 * for sorting the array of cards.
 */
 

package poker;

public class EvaluateRank {
	
		private int rank;
		private Card[] cardList;
		Value v=new Value();
		
		// Method to evaluate rank for a hand	 
		public int evalRank(String[] arr) {
			
			cardList = new Card[5];
			for(int i = 0; i < 5 ; i++) {
				cardList[i]=new Card(v.cardValue(arr[i].charAt(0)),v.cardSuit(arr[i].charAt(1)));
			}
			sort(cardList);
			
			int pairIndex = -1;
			rank = 1;  //assume its a High Card
			
			//check for pair
			for(int i = 0; i < 4; i++) 
			    if(cardList[i].getValue() == cardList[i+1].getValue()) {
			    	pairIndex = i;
			    	rank = 2;
			    	i = 4;
			    }

			//check for 2 pair
			if(rank == 2) {
			    for(int i = pairIndex + 2; i < 4; i++)
				if(cardList[i].getValue() == cardList[i+1].getValue())
				    rank = 3;
				}

			//check for 3 of a kind or full house
			for(int i = 0; i < 3; i++)
			    if(cardList[i].getValue() == cardList[i+1].getValue() && cardList[i+1].getValue() == cardList[i+2].getValue()) {
			    	rank = 4;
				if(i==0 && cardList[3].getValue()==cardList[4].getValue() || i==2 && cardList[0].getValue() == cardList[1].getValue())
				    rank = 7;
			    }
			
			//check for 4 of a kind
			for(int i = 0; i < 2; i++)
			    if(cardList[i].getValue() == cardList[i+1].getValue() && cardList[i+1].getValue() == cardList[i+2].getValue() &&
			       cardList[i+2].getValue() == cardList[i+3].getValue()) {
			    	rank = 8;
			    }

			//check for straight (if we haven't already found any pairs)
			if(rank == 1) 
			    if((cardList[4].getValue() - cardList[0].getValue() == 4) ||
			       (cardList[3].getValue() - cardList[0].getValue() == 3 && cardList[4].getValue() == 14 && cardList[0].getValue() == 2)) {
			    	rank = 5;
			    }

			//check for flush (if we haven't already found any pairs)
			boolean flush;
			if(rank == 1 || rank == 5) {
			    flush = true;
			    for(int i = 0; i < 4; i++)
				if(cardList[i].getSuit() != cardList[i+1].getSuit())
				    flush = false;
			    if(flush && rank == 5)
				rank = 9; //straight flush!
			    else if(flush)
				rank = 6;
			}
			    
			//check for royal flush (if it's a straight flush)
			if(rank == 9 && cardList[4].getValue() == 14 && cardList[0].getValue() == 10)
			    rank = 10; //royal flush!
			
			return rank;
		    }//end evalRank
		
		// Method to sort array of cards in ascending order ( Selection Sort )
	 	private void sort(Card[] a) {
			int idx;
			Card temp;
			for(int i = 0; i < a.length; i++) {
			    idx = i;
			    for(int j = i; j < a.length; j++) {
			    	if(a[idx].compareTo(a[j])>0)
					idx = j;
			    }
			    //swap the elements at i and idx
			    temp = a[idx];
			    a[idx] = a[i];
			    a[i] = temp;
			}
		}//end sort
	 	
}
