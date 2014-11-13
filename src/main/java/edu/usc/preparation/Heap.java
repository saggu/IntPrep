package edu.usc.preparation;

public class Heap {
	
	private static int N;
	
	public static int[] heapSort(int[] A){
		
		heapify(A);
		//System.out.println(N);
		for(int i = N;i >=0;i--){
			swap(A,0,i);
			N=N-1;
			maxHeap(A,0);
		}
		
		return A;
	}
	
	public static void heapify(int[] A){
		
		N = A.length - 1;
		
		for(int i=N/2;i>=0;i--){
			maxHeap(A,i);
		}
		
	}
	
	public static void maxHeap(int[] A, int i){
		
		int left = 2*i;
		int right = 2*i+1;
		int max = i;
		
		if(left <= N && A[left] > A[i]){
			max = left;
		}
		if(right <=N && A[right] > A[max]){
			max = right;
		}
		
		if(max != i){
			swap(A,i,max);
			maxHeap(A,max);
		}
	}
	
	public static void swap(int[] A, int i, int j){
		
		int temp = A[i];
		A[i] = A[j];
		A[j]=temp;
	}
}
