
/*At any stage, there is atleast one side of the array that is unsorted.
 *Count variable is a tweak to identify if the input array is rotated or not.*/
public class CircularlySortedArray {

	public static void main(String[] args) {
//		{8,9,2,3,4,5,6,7}
//		{7,8,9,3,4,5,6};
//		{9,10,11,12,0,1,2,3,4,5,6,7,8}
//		{7,8,9,10,11,12,13,14,15,3,4,5,6};
//		{11,12,15,18,2,5,6,8}
//		{3,4,5,6,7,8,9,2};		
//		{12,13,14,15,16,17,2,3,5,8,11};
		int arr[] = {7,1,2,3,4,5,6};
		circularlySorted(arr, 0, arr.length-1);
	}
	
	public static void circularlySorted(int[] arr, int low, int high) {
		int count = 0;
		while(low < high) {			
			int mid = low + (high - low) / 2 ;
			if(arr[mid] > arr[high] && arr[mid] > arr[low]) {
				low = mid;
				count++;
			}
			else if(arr[mid] < arr[low] && arr[mid] < arr[high]) {
				high = mid;
				count++;
			}
			else {
				if(count == 0) {
					System.out.println("Array is not rotated.");
					break;
				}
				else {
					System.out.println("Index:"+(mid+1)+" Element:"+arr[mid+1]);				
					break;
				}
			}			
		}
	} 
}