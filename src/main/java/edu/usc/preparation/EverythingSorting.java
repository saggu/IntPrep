package edu.usc.preparation;

public class EverythingSorting {
	
	public int[] BubbleSort(int[] A)
	{
		int temp = 0;
		for(int i=0;i<A.length;i++){
		
			for(int j=i;j<A.length;j++) {
			
				if(A[i] > A[j]){
					
					temp = A[i];
					A[i] = A[j];
					A[j]=temp;
				}
			}
		}
		
		printArray(A);
		
		return A;
		
	}
	
	
	public int[] MergeSort(int[] A) {

		if(A.length <= 0) return null;
		if(A.length <= 1) return A;
		
		int[] left = new int[A.length / 2];
		int[] right = new int[A.length - left.length];
		
		for(int i=0;i<left.length;i++) {
			
			left[i] = A[i];
		}
		
		for(int i=0;i<right.length;i++) {
			
			right[i] = A[right.length + i];
		}
		
		MergeSort(left);
		MergeSort(right);
		Merge(left,right,A);
	
		return A;
	}

			
	public void Merge(int[] left, int[] right, int[] result){
		
		int i=0,j =0,k=0;
		
		while(i<left.length && j<right.length){
			
			if(left[i] <= right[j]){
				
				result[k++] = left[i++];
			}
			else{
				result[k++] = right[j++];
			}
			
		}
		
		for(int iLeft=i;iLeft<left.length;iLeft++){
			result[k++] = left[iLeft];
		}
		
		for(int iRight=j;iRight<right.length;iRight++){
			result[k++] = right[iRight];
		}
	}
	
	
	public void QuickSort(int[] A){
		
		RecursiveQuickSort(A,0, A.length-1);
		
		printArray(A);
	}
	
	public void RecursiveQuickSort(int[] A, int low, int high){
		
		if(A==null || A.length == 0) return;
		
		if(low >= high) return;
		
		int middle = low + (high - low) / 2;
		int pivot = A[middle];
		
		int i=low, j=high;
		
		while (i <= j) {
			
			while(A[i] < pivot) {
				i++;
			}
			
			while(A[j] > pivot) {
				j--;
			}
			
			if(i <= j) {
				
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
				j--;
			}
		}
		
		if(low < j) {
			
			RecursiveQuickSort(A, low, j);
		}
		
		if(high > i) {
			
			RecursiveQuickSort(A, i, high);
		}
		
		
	}
	
	public void printArray(int[] A)
	{
		for(int i: A){
			
			System.out.print(" " + i + " ");
		}
	}

}
