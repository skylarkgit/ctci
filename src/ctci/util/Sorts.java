package ctci.util;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorts {
	
	public static void main(String[] args) {
		Integer arr[] = {2, 6, 23, 2, 64, 2, 1, 3, 9};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
		int arr2[] = {2, 6, 23, 2, 64, 2, 1, 3, 9, 0};
		countingSort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		int arr3[] = {2, 0, 6, 23, 2, 64, 2, 1, 3, 9};
		radixSort(arr3);
		System.out.println(Arrays.toString(arr3));
		
		Integer arr4[] = {2, 0, 6, 23, 2, 64, 2, 1, 3, 9};
		mergeSort(arr4);
		System.out.println(Arrays.toString(arr4));
		
		Integer arr5[] = {2, 0, 6, 23, 2, 64, 2, 1, 3, 9};
		selectionSort(arr5);
		System.out.println(Arrays.toString(arr5));
		
		Integer arr6[] = {2, 0, 6, 23, 2, 64, 2, 1, 3, 9};
		insertionSort(arr6);
		System.out.println(Arrays.toString(arr6));
		
		Integer arr7[] = {2, 0, 6, 23, 2, 64, 2, 1, 3, 9};
		quickSort(arr7);
		System.out.println(Arrays.toString(arr7));
		
		Integer arr8[] = {2, 0, 6, 23, 2, 64, 2, 1, 3, 9};
		heapSort(arr8);
		System.out.println(Arrays.toString(arr8));
	}
	
	public static <T extends Comparable<T>> void mergeSort(T[] arr) {
		T intermediate[] = (T[])new Comparable[arr.length];
		mergeSort(arr, intermediate, 0, arr.length-1);
	}
	
	private static <T extends Comparable<T>> void mergeSort(T[] arr, T[] intermediate, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start+end) / 2;
		mergeSort(arr, intermediate, start, mid);
		mergeSort(arr, intermediate, mid + 1, end);
		int i = start;
		int j = mid + 1;
		int index = 0;
		while (i <= mid && j <= end) {
			intermediate[start + index++] = arr[i].compareTo(arr[j]) < 0 ? arr[i++] : arr[j++];
		}
		while (i <= mid) {
			intermediate[start + index++] = arr[i++];
		}
		while (j <= end) {
			intermediate[start + index++] = arr[j++];
		}
		System.arraycopy(intermediate, start, arr, start, end - start + 1);
	}
	
	public static void countingSort(int[] arr) {
		// Max Value in the array
		int maxVal = Arrays.stream(arr).max().getAsInt();
		
		// count map that first stores the count and then indices
		int[] countMap = new int[maxVal+1];
		for (int a: arr) {
			// count of element 'a' is increased
			countMap[a]++;
		}
		
		// Setting indices of the counts
		for (int num = 1; num<=maxVal; num++) {
			countMap[num] += countMap[num-1];
		}
		
		assert countMap[countMap.length - 1] == arr.length;
		
		// putting the element to their position
		int output[] = new int[arr.length];
		for (int a: arr) {
			output[countMap[a]-- - 1] = a;
		}
		
		// Copying the output to the array
		System.arraycopy(output, 0, arr, 0, arr.length);
	}
	
	private static int getDigitAtExp(int num, int exp) {
		return (num / exp) % 10;
	}
	
	public static void countingSort(int[] arr, int exp) {
		int[] countMap = new int[10];
		for (int a: arr) {
			countMap[getDigitAtExp(a, exp)]++;
		}
		
		for (int num = 1; num<=9; num++) {
			countMap[num] += countMap[num-1];
		}
		
		assert countMap[countMap.length - 1] == arr.length;
		
		int output[] = new int[arr.length];
		for (int i= arr.length -1; i>=0; i--) {
			int a = arr[i];
			output[countMap[getDigitAtExp(a, exp)]-- - 1] = a;
		}
		
		System.arraycopy(output, 0, arr, 0, arr.length);
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot - 1);
		quickSort(arr, pivot + 1, end);
	}
	
	private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
		int i = low;
		T pivot = arr[high];
		// Maintaining the last position where we find an element greater than pivot
		for (int j = low; j <= high; j++) {
			if (arr[j].compareTo(pivot) < 0) {				
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, high);
		return i;
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=i; j>0; j--) {
				if (arr[j].compareTo(arr[j-1]) < 0) {
					swap(arr, j-1, j);
				} else {
					break;
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		for (int i=0; i<arr.length;i++) {
			int minIndex = i;
			for (int j=i+1;j<arr.length;j++) {
				minIndex = arr[minIndex].compareTo(arr[j]) <= 0 ? minIndex : j;
			}
			swap(arr, i, minIndex);
		}
	}
	
	public static void radixSort(int[] arr) {
		int maxVal = Arrays.stream(arr).max().getAsInt();
		int exp = 1;
		// Applying counting sort once for all the exponents 
		while (maxVal > 0) {
			countingSort(arr, exp);
			exp*=10;
			maxVal/=10;
		}
	}
	
	public static <T extends Comparable<T>> void heapSort(T[] arr) {
		PriorityQueue<T> queue = new PriorityQueue<>(Arrays.asList(arr));
		for (int i = 0; queue.size() > 0; i++) {
			arr[i] = queue.poll();
		}
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		// Iterate over the whole array in n number of passes
		// swap them if they are out of order
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (arr[j+1].compareTo(arr[j]) < 0) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
