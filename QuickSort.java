
public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {4,3,5,7,2,6,3,2};
		System.out.println("Before sort");
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]);		
		quicksort(arr, 0, arr.length-1);
		System.out.println();
		System.out.println("After sort");
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]);
	}
	
	public static void quicksort(int[] arr, int i, int j) {
		if(i < j) {
			int partitionIndex = partition(arr, i, j);
			quicksort(arr, i, partitionIndex - 1);
			quicksort(arr, partitionIndex + 1, j);
		}
	}
	
	public static int partition(int[] arr, int i , int j) {
		int pivot = arr[j];
		int partitionIndex = i;
		for(int k=i;k<j;k++) {
			if(arr[k]<=pivot) {
				swap(arr, k, partitionIndex);
				partitionIndex++;
			}
		}
		swap(arr, partitionIndex, j);
		return partitionIndex;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
