
public class CountOfAnElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,5,5,5,5,5,9,9,11};
//		int[] arr = {1,1,1,1,1,1,1,1};
		int count = countElement(arr, 0, arr.length-1, 1, 0);
		System.out.println(count);
	}
	
	/*Recursive approach. O(n) worst case*/
	private static int countElement(int[] arr, int i, int j, int number, int count) {
		int mid = i + (j - i)/2;
		if(i > j) {
			return count;
		}
		if(arr[mid] == number) {			
			count++;
			count = countElement(arr, i, mid-1, number, count);
			count = countElement(arr, mid+1, j, number, count);
		}
		else if(number < arr[mid]) {
			j = mid - 1;
			count = countElement(arr, i, j, number, count);
		}
		else {
			i = mid + 1;
			count = countElement(arr, i, j, number, count);
		}
		return count;
	}
}
