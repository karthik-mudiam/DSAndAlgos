
import java.util.ArrayList;
import java.util.List;

/*Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die. Given a flowerbed (represented as an array containing booleans), return if a given number of new flowers can be planted in it without violating the no-adjacent-flowers rule 
Sample inputs 

Input: 1,0,0,0,0,0,1,0,0 

3 => true 
4 => false 
Input: 1,0,0,1,0,0,1,0,0 

1 => true 
2 => false 
input: 0 

1 => true 
2 => false  

public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) { 

// Implementation here 
}*/

public class Flowerbed {
	
	public static void main(String[] args) {
		List<Boolean> list = new ArrayList<Boolean>();
//		list.add(true);
//		list.add(false);
//		list.add(false);
//		list.add(true);
//		list.add(false);
//		list.add(false);
//		list.add(true);
//		list.add(false);
//		list.add(false);
//		list.add(true);
//		list.add(false);
//		list.add(false);
//		list.add(false);
//		list.add(false);
//		list.add(false);
//		list.add(true);
//		list.add(false);
//		list.add(false);
		list.add(false);
		list.add(false);
		list.add(false);
		list.add(false);
		list.add(false);
		list.add(false);
		list.add(false);
		System.out.println(canPlaceFlowers1(list, 4));
	}
	
	public static boolean canPlaceFlowers1(List<Boolean> flowerbed, int numberToPlace) {
		int availableSpots = 0;
		int size  = flowerbed.size();
		// Base cases
		if(numberToPlace == 0) {			
			return true;
		}
		if(numberToPlace > size) {
			return false;
		}
		int i = 0;
		while(i < size) {
			if(flowerbed.get(i)) {
				i += 2;
				continue;
			}
			else if(!flowerbed.get(i) && i == 0) {
				if(!flowerbed.get(i+1)) {
					availableSpots++;					
					if(availableSpots == numberToPlace) {						
						return true;
					}
				}
				i += 2;
			}
			else if(!flowerbed.get(i) && i == size-1) {
				if(!flowerbed.get(i-1)) {
					availableSpots++;					
					if(availableSpots == numberToPlace) {
						return true;
					}
				}
				i += 2;
			}
			else if(!flowerbed.get(i)) {
				if(!flowerbed.get(i-1) && !flowerbed.get(i+1)) {
					availableSpots++;					
					if(availableSpots == numberToPlace) {
						return true;
					}
				}
				i += 2;
			}
			
		}		
		return false;
	}

}
