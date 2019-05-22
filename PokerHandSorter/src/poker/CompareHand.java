/* Java Class to break tie between players with same rank.
 * This class defines method to break tie between players by taking
 * array of cards of both players and rank for tie between two players
 * and generates output as an integer which is used by calling method 
 * to decide the winning player.
 */



package poker;

public class CompareHand {
	
	// Method to break tie between two players
	public int compareHands(int[] arr1, int[] arr2, int rank) {
		
		switch(rank) {
		case 1: {
			//tie breaker for Highest Card Rank
			for(int i = 4; i >= 0; i--) {
				if(arr1[i] > arr2[i]) {
					return 1;
				}
				else if(arr1[i] < arr2[i]) {
					return -1;
				}
			}
		}
		case 2: {
			// tie breaker for both players having a pair
			int temp1 = 0, temp2 = 0;
			for(int i = 0; i < 4; i++) {
				if(arr1[i] == arr1[i+1])
					temp1 = arr1[i];
			}
			for(int i = 0; i < 4; i++) {
				if(arr2[i] == arr2[i+1])
					temp2 = arr2[i];
			}
			if(temp1 > temp2)
				return 1;
			else if(temp1 < temp2)
				return -1;
			else {
				for(int j = 4; j >= 0; j--) {
					if(arr1[j] > arr2[j]) {
						return 1;
					}
					else if(arr1[j] < arr2[j]) {
						return -1;
					}
				}
			}	
		}
		case 3: {
			// tie breaker for both players having two pairs
			int temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0;
			for(int i = 0; i < 2; i++) {
				if(arr1[i] == arr1[i+1] && arr1[i+2] == arr1[i+3]) {
					temp1 = arr1[i+3];
					temp3 = arr1[i+1];
				}
			}
			for(int i = 0; i < 2; i++) {
				if(arr2[i] == arr2[i+1] && arr2[i+2] == arr2[i+3]) {
					temp2 = arr2[i+3];
					temp4 = arr2[i+1];
				}
			}
			if(temp1 > temp2)
				return 1;
			else if(temp1 < temp2)
				return -1;
			else {
				if(temp3 > temp4)
					return 1;
				else if(temp3 < temp4)
					return -1;
				else {
					for(int j = 4;j >= 0; j--) {
						if(arr1[j] > arr2[j]) {
							return 1;
						}
						else if(arr1[j] < arr2[j]) {
								return -1;
						}
					}
				}
			}
		}
		case 4: {
			// tie breaker for both players with three of a kind
				int temp1 = 0, temp2 = 0;
				for(int i = 0; i < 3; i++) {
				if(arr1[i] == arr1[i+1] && arr1[i+1] == arr1[i+2])
					temp1 = arr1[i];
				}
				for(int i = 0; i < 3; i++) {
				if(arr2[i] == arr2[i+1] && arr2[i+1] == arr2[i+2])
					temp2 = arr2[i];
				}
				if(temp1 > temp2)
					return 1;
				else if(temp1 < temp2)
					return -1;
				else {
					for(int j = 4; j >= 0; j--) {
						if(arr1[j] > arr2[j]) {
							return 1;
						}
						else if(arr1[j] < arr2[j]) {
							return -1;
						}
					}
				}
		}
		case 5: {
			// tie breaker for both players with a straight
			for(int j = 4; j >= 0; j--) {
				if(arr1[j] > arr2[j]){
					return 1;
				}
				else if(arr1[j] < arr2[j]) {
					return -1;
				}
			}
		}
		case 6: {
			// tie breaker for both players with a flush
			for(int j = 4 ; j >= 0; j--) {
				if(arr1[j] > arr2[j]) {
					return 1;
				}
				else if(arr1[j] < arr2[j]) {
					return -1;
				}
			}
		}
		case 7: {
			//tie breaker for both players with a full house
			int temp1 = 0, temp2 = 0;
			for(int i = 0; i < 3; i++) {
				if(arr1[i] == arr1[i+1] && arr1[i+1] == arr1[i+2])
					temp1 = arr1[i];
			}
			for(int i = 0; i < 3; i++) {
				if(arr2[i] == arr2[i+1] && arr2[i+1] == arr2[i+2])
					temp2 = arr2[i];
			}
			if(temp1 > temp2)
				return 1;
			else if(temp1 < temp2)
				return -1;
			else {
				int temp3 = 0, temp4 = 0;
				for(int j = 0; j < 4; j++) {
					if(arr1[j] == arr1[j+1] && arr1[j+1] != arr1[j+2])
						temp3 = arr1[j];
				}
				for(int j = 0; j < 4; j++) {
					if(arr2[j] == arr2[j+1] && arr2[j+1] != arr2[j+1])
						temp4 = arr2[j];
				}
				if(temp3 > temp4)
					return 1;
					else if(temp3 < temp4)
					return -1;
			}
		}
			
		case 8: {
			// tie breaker for both players with four of a kind
				int temp1 = 0, temp2 = 0;
				for(int i = 0; i < 2; i++) {
				if(arr1[i] == arr1[i+1] && arr1[i+1] == arr1[i+2] && arr1[i+2] == arr1[i+3])
					temp1 = arr1[i];
				}
				for(int i = 0; i < 2; i++) {
				if(arr2[i] == arr2[i+1] && arr2[i+1] == arr2[i+2] && arr2[i+2] == arr2[i+3])
					temp2 = arr2[i];
				}
				if(temp1 > temp2)
					return 1;
				else if(temp1 < temp2)
					return -1;
				else {
					for(int j = 4; j >= 0; j--) {
						if(arr1[j] > arr2[j]){
							return 1;
						}
						else if(arr1[j] < arr2[j]) {
							return -1;
						}
					}
				}
		}
		case 9: {
			// tie breaker for both players with a straight flush
			for(int j = 4; j >= 0; j--) {
				if(arr1[j] > arr2[j]) {
					return 1;
				}
				else if(arr1[j] < arr2[j]) {
					return -1;
				}
			}
		}
		case 10: return 0; // none player wins for both royal flush
		}
		return 0;
	} // end compareHands
}
