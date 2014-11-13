package edu.usc.preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//EverythingSorting es = new EverythingSorting();
		//int[] A = {1,4,67,54,9,0,-4,23};
		//es.BubbleSort(A );
		//es.MergeSort(A);
		
		//es.printArray(A);
		
		//es.QuickSort(A);
		
		//es.printArray(Heap.heapSort(A));
		
		
		ArraysAndStrings as = new ArraysAndStrings();
		
		int[][] matrix = as.initialiseMatrix(5, 5);
		
		as.printMatrix(matrix);
		
		as.printMatrixZigZagRightBottom(matrix);
		
		
		
	}

}
