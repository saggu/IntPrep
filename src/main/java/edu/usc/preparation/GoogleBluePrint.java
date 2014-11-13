package edu.usc.preparation;

public class GoogleBluePrint {
	
	public int SquaresWithinRange(int min, int max){
		
		int minR = (int)Math.floor(Math.sqrt(min));
		int maxR = (int)Math.floor(Math.sqrt(max));
		
		
		return (maxR-minR+1)*2;
	}
	
	
	public int DigitalRoot(int number) {
		//System.out.println(number);
		if(number <= 9){
			return number;
		}
		
		if(number%10 == 9){
			return DigitalRoot(number/10);
		}
		
		return DigitalRoot(number%10 + number/10);
	}
	
	public boolean isPerfectSquare(int number){
		
		int rem = number%10;
		
		if(rem == 2 || rem == 3 || rem == 7 || rem == 8){
			return false;
		}
		
		int dR = DigitalRoot(number);
		//System.out.println(dR);
		if(dR != 1 && dR != 4 && dR != 7 && dR != 9){
			return false;
		}
		
		int sqrt = (int) Math.sqrt(number);
		//System.out.print(number);
		return sqrt*sqrt == number;
		
		
	}
	
	

}
