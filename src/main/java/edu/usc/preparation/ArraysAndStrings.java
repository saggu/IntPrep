package edu.usc.preparation;

import java.util.ArrayList;

public class ArraysAndStrings {

	public void uniqueChars(String s) //prints whether the characters in the string are all unique
	{
		if(s.length() > 256)
		{
			System.out.println("String not unique");
			return;
		}
		
		boolean[] unique = new boolean[256];
		
		for(int i=0;i<s.length();i++)
		{
			int val = s.charAt(i);
			
			if(unique[val])
			{
				System.out.println("Not Unique");
				return;
			}
			
			unique[val] = true;
		}
		
		System.out.println("Unique");
		
	}
		
	public void reverseString(String s) //reverse a string
	{
		char[] reverse = new char[s.length()];
		
		int i=0;
		int j = s.length()-1;
		
		while(i<=j)
		{
			reverse[i] = s.charAt(j);
			reverse[j] = s.charAt(i);
			
			i++;
			j--;
			
		}
		
		System.out.println(reverse);
	}
		
	public void checkIfPermutation(String s1, String s2) //checks whether s1 and s2 is a permutation of each other
	{
		if(s1.length() != s2.length())
		{
			System.out.println(s1 + " is not a permutation of " + s2);
			return;
		}
		
		int[] letters = new int[256];
		
		for(int i=0;i<s1.length();i++)
		{
			int c = s1.charAt(i);
			letters[c]++;
		}
		
		for(int i=0;i<s2.length();i++)
		{
			int c = s2.charAt(i);
			if(--letters[c] < 0)
			{
				System.out.print(s1 + " is not a permutation of " + s2);
				return;
			}
		}
		
		System.out.println(s1 + " is  a permutation of " + s2);
	}

	public void replaceWith20(String str) //replace all the spaces in the string with %20
    {
        int count=0;
        
        for(int i =0;i<str.length();i++)
        {
            if(str.charAt(i) == ' ')
            {
                count++;
            }
        }
        
        char[] replace= new char[str.length() + (count-1)*3];
        
        int j= 0;
        for(int i =0;i<str.length();i++)
        {
            
            if(str.charAt(i) == ' ')
            {
                replace[j++] = '%';
                //j++;
                replace[j++] = '2';
                //j++;
                replace[j++] = '0';
            }
            else
            {
                replace[j++] = str.charAt(i);
                //j++;
            }
        }
        
        System.out.print(replace);
    }

	public void stringCompression(String s) //compresses a string aabbcc to a2b2c2
	{
		int count = 1;
		
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i) == s.charAt(i+1))
			{
				count++;
			}
			else
			{
				System.out.print(s.charAt(i)+""+ count);
				count=1;
			}
		}
		
		System.out.print(s.charAt(s.length()-1) + "" + count);
		
	}

	public void rotateMatrix(int[][] matrix, int n) //rotate  a matrix
	{
		for (int layer=0;layer<n/2;++layer)
		{
			int first = layer;
			int last = n-1-layer;
			
			for(int i=first;i<last;++i)
			{
				int offset = i-first;
				
				int top = matrix[first][i];//save top
				
				matrix[first][i] = matrix[last-offset][first];//left - >top
				
				matrix[last-offset][first] = matrix[last][last-offset]; //bottom - >left
				
				matrix[last][last-offset] = matrix[i][last]; // right - > bottom
				
				matrix[i][last] = top; //top->right
				
				
				
			}
		}
	}

	public void setZeroMatrix(int[][] matrix) //set the row i and column j of matrix to 0 is matrix[i][j] = 0
	{
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				if(matrix[i][j] == 0)
				{
					indexes.add(i);
					indexes.add(j);
				}
			}
		}
		
		
		
		for(int i=0;i<indexes.size();i++)
		{
			int index = indexes.get(i);
			if(i%2 == 0)
			{
				matrix = nullifyRow(matrix, index);
			}
			else
			{
				matrix = nullifyColumn(matrix, index);
			}
		}
		
		printMatrix(matrix);
		
		
	}
	
	public int[][] nullifyRow(int[][] matrix, int row)
	{
		int columns = matrix[0].length;
		
		for(int j=0;j<columns;j++)
		{
			matrix[row][j] = 0;			
		}
		
		return matrix;
	}
	
	public int[][] nullifyColumn(int[][] matrix, int column)
	{
		int rows = matrix.length;
		
		for(int j=0;j<rows;j++)
		{
			matrix[j][column] = 0;			
		}
		
		return matrix;
	}
	
	public void printMatrix(int[][] matrix)
	{
		int rows = matrix.length;
		
		int columns = matrix[0].length;
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				if(matrix[i][j] < 10)
				{
					System.out.print(matrix[i][j] + "  ");
				}
				else
				{
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.print("\n");
		}
	}
	
	public int[][] initialiseMatrix(int rows,int columns)
	{
		int[][] matrix= new int[rows][columns];
		
		int count=1;
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				matrix[i][j] = count++;
			}
		}
		
		//matrix[rows-2][columns-3]=0;
		//matrix[2][3] = 0;
		//matrix[4][4]=0;
		return matrix;
	}
	
	public void printMatrixZigZag(int [][] matrix)  //print a matrix in the zig zag form diagonally
	{
		int rows = matrix.length;
			int i=0,j=0;
		
		while(i<rows)
		{
	         System.out.print(matrix[i][j] + " -> ");
	    
	         if(i==rows-1)
	         {
	             i = j+1; j = rows-1;
	         }
	         else if(j==0)
	         {
	             j = i+1; i = 0;
	         }
	         else
	         {
	             i++; j--;
	         }
	    }
	}
	
	public void printMatrixZigZagRightBottom(int[][] matrix){
		
		int rows = matrix.length-1;
		int i=rows;
		int j= rows;
		
		
		while(i>=0){
			
			System.out.print(matrix[i][j]+ " ->");
			
			if(i==0){
				i=j-1; j= 0;
			}
			else if(j==rows){
				j=i-1; i = rows;
			}
			else{
				i--;j++;
			}
		}
	}
	
	public void printMatrixSpiral(int[][] matrix) //print a matrix spirally
	{
		 	int top = 0;
		 	int rows = matrix.length - 1;
	     	int left = 0;
	     	int columns = matrix[0].length - 1;
		
	     	while(true)
		     {
		         // Print top row
		         for(int j = left; j <= columns; ++j) System.out.print(matrix[top][j] + " ");
		         top++;
		         if(top > rows || left > columns) break;
		         //Print the rightmost column
		         for(int i = top; i <= rows; ++i) System.out.print(matrix[i][columns] + " ");
		         columns--;
		         if(top > rows || left > columns) break;
		         //Print the bottom row
		         for(int j = columns; j >= left; --j) System.out.print(matrix[rows][j] + " ");
		         rows--;
		         if(top > rows || left > columns) break;
		         //Print the leftmost column
		         for(int i = rows; i >= top; --i) System.out.print(matrix[i][left] + " ");
		         left++;
		         if(top > rows || left > columns) break;
		     }
	}

	public ArrayList<String> stringPermutation(String s) //all the permutations of a string
	{
		ArrayList<String> perms = new ArrayList<String>();
		if(s==null || s.length()==0)
		{
			return null;
		}
		//if(s.length() == 0)
		//{
			//perms.add("");
			//return perms;
		//}
		
		char c = s.charAt(0);
		//perms.add(String.valueOf(c));
		String remainder = s.substring(1);
		
		ArrayList<String> words = stringPermutation(remainder);
		if(words != null)
		{
			for(String word:words)
			{
				for (int i=0;i<=word.length();i++)
				{
					perms.add(insertCharAt(word, i, c));
				}
			}
		}
		perms.add(String.valueOf(c));
		
		for(int i=0;i<perms.size();i++)
            System.out.print(perms.get(i) + " ");
			
		//System.out.print(perms.size());
        return perms;
		
	}
	
	public String insertCharAt(String s, int i, char c)
	{
		String begin = s.substring(0,i);
		String last = s.substring(i);
		
		return begin + c + last;
	}
	
	public long stringToLong(String strLong){
	        
	        int i=0;
	        long number = 0;
	        boolean isNegative=false;
	        int strLen = strLong.length();
	        
	        if(strLong.charAt(0) == '-'){ //check if the first char is -, then multiply the number by -1 in the end
	            isNegative = true;
	            i=1;
	        }
	        
	        while(i < strLen){
	            
	            number *= 10;
	            number += strLong.charAt(i) - '0';
	            i++;
	        }
	        if(isNegative)
	            number *= -1L;
	        
	        return number;
	    
	}
	
	public String intToString(int number){
		
		int i=0;
		boolean isNegative = false;
		
		char[] temp = new char[11]; //should be parameterised
		
		if(number < 0){
			number *= -1;
			isNegative = true;
		}
		
		
		do{
			temp[i++] = (char)((number % 10) + '0');
			number /= 10;
		} while(number !=0);
		
		StringBuffer sb = new StringBuffer();
		
		if(isNegative)
			sb.append('-');
		
		while(i>0)
		{
			sb.append(temp[--i]);
		}
		return sb.toString();
	}
	
}

