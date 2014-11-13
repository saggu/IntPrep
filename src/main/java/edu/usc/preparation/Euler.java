package edu.usc.preparation;

import static java.lang.Math.floor;
import java.util.Scanner;

//Solutions to problems as posted at http://projecteuler.net/ The name of the functions match the problem number they solve

public class Euler {
	
	public void PE2()
    {
        //sum of even number in fibonacci series less than 4000000
         int num1 =0;
        int num2=1;
        int temp=0;
        int sum=0;
        
        do
        {
            if (num2 % 2 == 0)
            {
                sum = sum + num2;
            }

            temp = num1 + num2;
            num1 = num2;
            num2 = temp;
        } while (num2<4000000);
        
        System.out.println(sum);
        
    }
    
    public void PE3()
    {
        
        //largest prime factor of the given number = 600851475143L
        long num3;
        num3 = 600851475143L;
        long i =3;
        
        while (num3 > 1 )
        {
            if (num3 % i == 0)
            {
                num3 = num3 / i; //divide to make the number smaller and allow the function to scale
            }
            else
            {
                   i = i + 2; //only check odd numbers
            }
            
        }
        
        System.out.println(i);
        
        
    }
    public void PE4() //find maximum palindrome of a product of 2, 3 digit numbers
    {
        int max = 0;
        for (int i = 999;i > 0;i--)
        {
            for(int j=999;j>0; j--)
            {
                if(i*j == reverse(i*j)) //check if the product is a palindrome
                {
                    if (i*j > max)
                    {
                        max = i*j;
                    }
                }
            }
        }
        System.out.println(max);
        
    }
    
    
    public void PE5() //find the smallest positive number that is evenly divisible by all of the numbers from 1 to 20
    {
        boolean complete = false;
        int iCount = 0;
        int divisor = 1;
         
        do
        {
            iCount++;
            for(divisor = 1; divisor <= 20; divisor ++)
            {
                if (iCount % divisor != 0)
                {
                    break;
                }
                else if (iCount % divisor == 0 && divisor == 20){
                    complete = true;
                }
            }          
             
        } while(!complete);
 
        System.out.println(iCount);
        
    }
    
    public void PE6(int n) //Find the difference between the sum of the squares of the first 
    					   //one hundred natural numbers and the square of the sum
    {
        int sumofSquare;
        sumofSquare = n*(n+1)*(2*n+1)/6;
        
        int sum = n*(n+1) / 2;
        
        System.out.println(sum*sum - sumofSquare);
        
    }
    
    public int reverse(int num) //reverse a number
    {
        int reverse = 0;
        
        while (num != 0)
        {
            reverse = reverse * 10;
            reverse =  reverse + num%10;
            
            num = num / 10;
        }
        return reverse;
        
    }
    
    public void PE7(long num) //What is the 10001(num in this case) st prime number?
    {
        long temp = 0;
         for(long i=2;i<1000000;i++)
         {
            if(isPrime(i)) //Check if it is prime, efficiently
             {
                 temp++;
             }
             
              if(temp == num)
             {
                System.out.println(i); //Print the num'st number
                break;
             }
             
         }
         
    }
    
    public void PE8() //Find the greatest product of five consecutive digits in the 1000-digit number.
    {
        String strBig = "73167176531330624919225119674426574742355349194934" +
                          "96983520312774506326239578318016984801869478851843" +
                            "85861560789112949495459501737958331952853208805511" +
                            "12540698747158523863050715693290963295227443043557" +
                            "66896648950445244523161731856403098711121722383113" +
                            "62229893423380308135336276614282806444486645238749" +
                            "30358907296290491560440772390713810515859307960866" +
                            "70172427121883998797908792274921901699720888093776" +
                            "65727333001053367881220235421809751254540594752243" +
                            "52584907711670556013604839586446706324415722155397" +
                            "53697817977846174064955149290862569321978468622482" +
                            "83972241375657056057490261407972968652414535100474" +
                            "82166370484403199890008895243450658541227588666881" +
                            "16427171479924442928230863465674813919123162824586" +
                            "17866458359124566529476545682848912883142607690042" +
                            "24219022671055626321111109370544217506941658960408" +
                            "07198403850962455444362981230987879927244284909188" +
                            "84580156166097919133875499200524063689912560717606" +
                            "05886116467109405077541002256983155200055935729725" +
                            "71636269561882670428252483600823257530420752963450";
        
        int max = 1;
        for(int i=0;i<strBig.length()-5;i++)
        {
            int product = Integer.parseInt(strBig.substring(i,i+1))*
                          Integer.parseInt(strBig.substring(i+1,i+2))*
                          Integer.parseInt(strBig.substring(i+2,i+3))*
                          Integer.parseInt(strBig.substring(i+3,i+4))*
                          Integer.parseInt(strBig.substring(i+4,i+5));
            
            if (product>max)
            {
                max = product;
            }
        }
        
        System.out.println(max);
    }
    
    public void PE9() //There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    				 //Find the product abc.
    {
        for(int i=1;i<1000;i++) //ooh. runs in O(n3)
        {
            for(int j=1;j<1000;j++)
            {
                for(int k=1;k<1000;k++)
                {
                    if(i+j+k == 1000)
                    {
                        if(pytha(i, j, k)) //check if i,j,k is a Pythagorean triple
                        {
                            System.out.println(i + " " + j + " " + k);
                            return; //found the triple so return
                        }
                    }
                }
            }
        }
    }
    
    public boolean pytha(int a, int b, int c) // returns if a,b,c is a Pyhtagorean triple
    {
        if(a>b && a>c && (a*a == b*b + c*c))
        {
            return true;
        }
        if(b>a && b>c && (b*b == a*a + c*c))
        {
            return true;
        }
        if(c>b && c>a && (c*c == b*b + a*a))
        {
            return true;
        }
        return false;
    }
    
    public void PE10() //Find the sum of all the primes below two million
    {
        long sum = 2;
        for(long i =3;i<2000000;i=i+2)
        {
            if(isPrime(i))
            {
                sum+=i;
            }
        }
        
        System.out.println(sum);
    }
    
    public boolean isPrime(long num) //returns if the number is prime, real efficient
    {
            
            boolean isPrime = true;
            if(num==2)
            {
                isPrime = true;
                //return isPrime;
            }
            else if(num%2 == 0)
            {
                isPrime = false;
                //return isPrime;
            }
             else
            {
             for(long i = 3;i< floor(Math.sqrt(num)) + 1;i=i+2) //run from 3 to sqrt of the number, checking only odd numbers
                 {
                    if(num%i == 0)
                    {
                        isPrime = false;
                     return false;
                    }
                }
            }
        
        return isPrime;
    }
    
    
    
    /*Find the maximum total from top to bottom of the triangle below:

    	75
    	95 64
    	17 47 82
    	18 35 87 10
    	20 04 82 47 65
    	19 01 23 75 03 34
    	88 02 77 73 07 63 67
    	99 65 04 28 06 16 70 92
    	41 41 26 56 83 40 80 70 33
    	41 48 72 33 47 32 37 16 94 29
    	53 71 44 65 25 43 91 52 97 51 14
    	70 11 33 28 77 73 17 78 39 68 17 57
    	91 71 52 38 17 14 91 43 58 50 27 29 48
    	63 66 04 68 89 53 67 30 73 16 69 87 40 31
    	04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 */
    
    
    public void PE18()
    {
        //int index = 15;
        
         @SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
         String line;
         //line = "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
         int[] line1 = {23, 33, 44, 81, 80, 92, 93, 75, 94, 88, 23, 61, 39, 76, 22, 03, 28, 94, 32, 06, 49, 65, 41, 34, 18, 23, 8, 47, 62, 60, 03, 63, 33, 13, 80, 52, 31, 54, 73, 43, 70, 26, 16, 69, 57, 87, 83, 31, 03, 93, 70, 81, 47, 95, 77, 44, 29, 68, 39, 51, 56, 59, 63, 7, 25, 70, 7, 77, 43, 53, 64, 03, 94, 42, 95, 39, 18, 01, 66, 21, 16, 97, 20, 50, 90, 16, 70, 10, 95, 69, 29, 6, 25, 61, 41, 26, 15, 59, 63, 35};         
         //line1
                  
         
         while(scn.hasNextLine() && !(line = scn.nextLine()).equals("")) //read the file from command line
         {
             
             String [] line2 = line.split(" ");
             int line3[] = new int[line2.length];
             
             for(int i=0;i<line2.length;i++)
             {
                 if(line1[i] > line1[i+1])
                 {
                     line3[i] = Integer.parseInt(line2[i]) + line1[i];
                 }
                 else
                 {
                     line3[i] = Integer.parseInt(line2[i]) + line1[i+1];
                 }
             }
             
             for(int i=0;i<line3.length;i++)
             {
                 line1[i] = line3[i];
             }
         }
         
         System.out.print(line1[0]);
            
    }
    


    /* PE 12 - The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

    Let us list the factors of the first seven triangle numbers:

         1: 1
         3: 1,3
         6: 1,2,3,6
        10: 1,2,5,10
        15: 1,3,5,15
        21: 1,3,7,21
        28: 1,2,4,7,14,28

    We can see that 28 is the first triangle number to have over five divisors.

    What is the value of the first triangle number to have over five hundred divisors? */

    public void PE12()
    {
        int number = 0;
        int i = 1;
 
        while(Factors(number) < 500) 
        {
             number += i;
                i++;
            }
        
        System.out.print(number);
    }
    
    /*
     *The following iterative sequence is defined for the set of positive integers:

			n → n/2 (n is even)
			n → 3n + 1 (n is odd)

		
		Which starting number, under one million, produces the longest chain?
     */
    
    public void PE14()
    {
        long max = 0;
        for(long i =1; i<1000000;i++)
        {
            long n = Sequence(i);
            if (n > max)
            {
                max = n;
                System.out.print(i + "\n");
            }
        }
        
        System.out.print(max);
    }
    
    public void PE34() //145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
    					//Find the sum of all numbers which are equal to the sum of the factorial of their digits.
    {
        int[] factorials = {1,1,2,6,24,120,720,5040,40320,362880}; //factorials of 0 till 9
        
        int sum=0;
        
        for(int i=3;i<999999;i++)
        {
            int sumOfFacts = 0;
            int number = i;
            while (number > 0) {
                 int d = number % 10;
                    number /= 10;
                sumOfFacts += factorials[d];
            }
 
            if (sumOfFacts == i) {
                sum += i;
                }
            }
        
        System.out.print(sum);
    }
    
    public void PE35() //The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
    					// There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
    					//How many circular primes are there below one million?

    {///needs refinement
        int count = 4;
        boolean isCircularPrime = true;
        
        for(int i=11;i<1000000;i=i+2)
        {
            int number = i;
            isCircularPrime = true;
            
            if(isPrime(number))
            {
            while(number>0)
            {
                int d = number % 10;
                if(d%2 == 0 || d==5)
                {
                    isCircularPrime = false;
                    break;
                    
                }
                    number /= 10;
            }
            
            if(isCircularPrime)
            {
                count++;
                
            }
            }
            
            
        }
        
        System.out.print(count);
    }
    
    public long Sequence(long num) //returns the numbers of items generated by the collatz sequence for the given number
    {
        long count = 1;
        while(num !=1)
        {
            if(num % 2 == 0)
            {
                num = num/2;
            }
            else
            {
                num = num*3+1;
            }
            count++;
        }
        return count;
        
    }
    public long GenerateTriangleNumber (long num)
    {
        return num * (num +1) / 2;
        
    }
    
    public long Factors(long num) //returns the total numbers of divisors
    {
        long nod = 0;
        int sqrt = (int) Math.sqrt(num);
        for(long i=1;i<=sqrt;i++) //check until the sqaure root
        {
            if(num%i == 0)
            {
                nod+=2;
            }
            
        }
        
        if(sqrt*sqrt == num) //if its a perfect square, decrease one
        {
            nod--;
        }
        return nod;
    }

}
