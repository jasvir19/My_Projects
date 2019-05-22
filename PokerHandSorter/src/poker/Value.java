/* Java Class to define value and suit of the card.
 * Card value and suit is mapped to an integer and is returned 
 * as output with character as an input.
 */

package poker;

public class Value {
	
	 public int cardValue(char c) {
	    	switch(c) {
	    	case '2' : return 2;
	    	case '3' : return 3;
	    	case '4' : return 4;
	    	case '5' : return 5;
	    	case '6' : return 6;
	    	case '7' : return 7;
	    	case '8' : return 8;
	    	case '9' : return 9;
	    	case 'T' : return 10;
	    	case 'J' : return 11;
	    	case 'Q' : return 12;
	    	case 'K' : return 13;
	    	case 'A' : return 14;
	    	default : return 0;
	    	}
	    	
	    }
	    
	    public int cardSuit(char c) {
	    	switch(c) {
	    	case 'C' : return 1;
	    	case 'D' : return 2;
	    	case 'S' : return 3;
	    	case 'H' : return 4;
	    	default : return 0;
	    	}
	    }
}
