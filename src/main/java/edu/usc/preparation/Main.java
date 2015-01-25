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
		
		
		//ArraysAndStrings as = new ArraysAndStrings();
		
		/*int[][] matrix = as.initialiseMatrix(3, 3);
		
		as.printMatrix(matrix);
		
		as.printMatrixZigZagRightBottom(matrix);*/
		
		//System.out.println(String.valueOf(as.infixEvaluation("4-4*4/7+5")));
		
		//InfixPostfixEvaluator ipe = new InfixPostfixEvaluator();
		
		//String expression = "(3-2)+5-(7*9)";
		
		//System.out.println(ipe.evaluateInfixExpression(expression));
		
		int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                {1,0,1,1,1,0,1,1,1,1,0,0,1},
                {0,0,0,0,1,0,1,0,1,0,1,0,0},
                {1,1,1,0,1,1,1,0,1,0,1,1,1},
                {1,0,1,0,0,0,0,1,1,1,0,0,1},
                {1,0,1,1,1,1,1,1,0,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1} };
		
		MazeRunner run = new MazeRunner(grid);
		
		run.traverse(0, 0);
		System.out.println(run.toString());
		
		
		
		
		
	}

}
