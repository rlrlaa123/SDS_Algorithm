package example01;

import java.util.Scanner;

public class problem1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		System.out.println("INPUT INTEGER : " + n);		

		int Nnew = n;
		int unitsDigit;
		int tensDigit;
		int sum;
		int unitsDigitSum;

		
		int cycle = 1;

		while(true){
			unitsDigit = Nnew%10;
			tensDigit = Nnew/10;
			sum = unitsDigit + tensDigit;
			unitsDigitSum = sum%10;
			System.out.println("tens : " + tensDigit);	
			System.out.println("units : " + unitsDigit);
			System.out.println("sum : " + sum);
			System.out.println("units of sum : " + unitsDigitSum);
			
			Nnew = unitsDigit*10 + unitsDigitSum;
			System.out.println("NEW INTEGER : " + Nnew);
			System.out.println();
			
			if(Nnew == n)
				break;
			
			cycle ++;
			
		}
		
		System.out.println("cycle : " + cycle);
	}

}
