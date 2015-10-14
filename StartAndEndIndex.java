
public class StartAndEndIndex {
	public static void main(String[] args) {
		int[] numbers = {0,0,2,3,3,3,3,4,7,7,9,9};
//		int[] numbers = {1,1,1,3,4,5,5,6,7};
//		int[] numbers = {0,0,0,0,1,1,2};
		System.out.println(findLeftOccurance(numbers, 0, numbers.length-1, 9, -1, -1, -1));
		firstoccurance(numbers, 0, numbers.length-1, 9);
	}	

	/*Recursion*/
	public static int findLeftOccurance(int[] numbers, int i, int j, int number, int index, int indexLeft, int indexRight) {
		int mid = i + (j - i) / 2;
		if(i>j) {
			return index;
		}
		if(numbers[mid] == number) {
			index = mid;
		}
		if(number <= numbers[mid]) {			
			indexLeft = findLeftOccurance(numbers, i, mid - 1, number, index, indexLeft, indexRight);
		}
		if(number > numbers[mid]) {
			indexRight = findLeftOccurance(numbers, mid + 1, j, number, index, indexLeft, indexRight);
		}
		return ((indexLeft == -1)?indexRight:indexLeft);
	}
	
	public static void firstoccurance(int[] arr, int i, int j, int number) {
		int index  = -1;
		while(i <= j) {
			int mid = i+(j-i)/2;
			if(arr[mid] == number){
				index = mid;
				j = mid - 1;
			}
			else if(number < arr[mid]) {
				j = mid - 1;
			}
			else if(number > arr[mid]) {
				i = mid + 1;
			}
		}
		System.out.println(index);
	}
}
