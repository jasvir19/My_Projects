/* Java Class to run Poker Hand Sorter.
 * This class is the primary class having main method to run poker game 
 * and calling methods of other classes to evaluate rank and compare
 * hands if there is a tie between both players.
 * It takes a data file as an input and outputs the numbers of turns each player wins.
 */

package poker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RunPoker {

	static String[] arr1 = new String[5];
	static String[] arr2 = new String[5];
	static int[] arrV1= new int[5];
	static int[] arrV2= new int[5];
	static String text, str1, str2, content;
	static int rank1, rank2;
	static int countP1, countP2;
	
	// main method to run poker hand sorter
	public static void main(String[] args) {
		BufferedReader br = null;
		Value v=new Value();
		CompareHand c=new CompareHand();
		EvaluateRank t=new EvaluateRank();
		Scanner sc = new Scanner(System.in);
		try	{
			System.out.println("Input text file :" );
			br=new BufferedReader(new FileReader(sc.next()));
			while((text = br.readLine()) != null) {
				text = text.replaceAll("\\s","");
				str1 = text.substring(0,10);
				str2 = text.substring(10,20);
				arr1[0] = str1.substring(0,2);
				arr1[1] = str1.substring(2,4);
				arr1[2] = str1.substring(4,6);
				arr1[3] = str1.substring(6,8);	
				arr1[4] = str1.substring(8,10);
				arr2[0] = str2.substring(0,2);
				arr2[1] = str2.substring(2,4);
				arr2[2] = str2.substring(4,6);
				arr2[3] = str2.substring(6,8);
				arr2[4] = str2.substring(8,10);
				
				rank1 = t.evalRank(arr1);
				rank2 = t.evalRank(arr2);
				if(rank1 > rank2)
					countP1++;		
				else if(rank1 < rank2)
					countP2++;
				else {
					for(int i = 0; i < 5; i++) {
						arrV1[i] = v.cardValue(arr1[i].charAt(0));
						arrV2[i] = v.cardValue(arr2[i].charAt(0));
					}
					Arrays.sort(arrV1);
			    	Arrays.sort(arrV2);
					int result = c.compareHands(arrV1,arrV2,rank1);
					if(result > 0)
						countP1++;	
					else if(result < 0)
						countP2++;
				}
			}
			System.out.println("Player 1 Hands : "+countP1);
			System.out.println("Player 2 Hands : "+countP2);
				
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
			    if (br != null)
			    br.close();
			 } catch (IOException ex) {
			    ex.printStackTrace();
		}
	}//end main method	
}

}
