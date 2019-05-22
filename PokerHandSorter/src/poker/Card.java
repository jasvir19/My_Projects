/* Java Class to define a Card in Poker Game.
 * This class is implementing comparable interface in Java 
 * and compareTo method is overridden to compare two cards 
 * on the basis of value and then suit if value for two cards is same.
 */

package poker;
    
public class Card implements Comparable<Card> {
	
	private int value, suit;

    private static String[] values  = { "2", "3", "4", "5", "6", "7", "8", "9", 
    									"10", "Jack", "Queen", "King", "Ace"};
    
    public static String rankAsString(int value) {
        return values[value];
    }

    Card(int value, int suit) {
        this.value=value;
        this.suit=suit;
    }

    public int getValue() {
         return value;
    }

    public int getSuit() {
        return suit;
    }
    
   	@Override
	public int compareTo(Card c) {
		if(value>(c.getValue())){
			return 1;
		}
		else if(value<(c.getValue())){
			return -1;
		}
		else if(value==c.getValue()) {
			if(suit>c.getSuit()) {
				return 1;
			}
			else if(suit<c.getSuit()) {
				return -1;
			}
		}
		return 0;
	}
   
}
