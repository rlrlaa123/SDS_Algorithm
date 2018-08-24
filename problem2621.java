package example01;

import java.util.Scanner;

public class problem2621 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		String[] card = new String[n];	
		Scanner sc = new Scanner(System.in);

		char[] color = new char[n];
		int[] number = new int[n];
		for (int i=0; i<n; i++){
			card[i] = sc.nextLine();
//			System.out.println(card[i].substring(0, 1));
	//		String st = card[i].substring(0,1);
			color[i] = card[i].charAt(0);
			String st = card[i].substring(2,3);
			number[i] = Integer.parseInt(st);
		}	
		
		

		// Check how many colors are same
		int Ncolors=0;
		for(int i = 0; i < n; i++){
			if(color[i]=='R')
				Ncolors += 1;
			if(color[i]=='B')
				Ncolors += 10;
			if(color[i]=='Y')
				Ncolors += 100;
			if(color[i]=='G')
				Ncolors += 1000;
		}
		
		System.out.println(Ncolors);
		
		// Check which and how many numbers are same
		int[] Nnumbers = new int[9];
		for(int i=0; i<9; i++){
			Nnumbers[i] = 0;
			
		}
		for(int i=0; i<9; i++){
			
			Nnumbers[number[i]-1] =+ 1;

		}
		
		for(int i=0; i<9; i++){
			System.out.println(Nnumbers[i]);
	
		}

	}
}
