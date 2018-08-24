package example01;

import java.util.Arrays;
import java.util.Scanner;

public class problem2621_sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] Ncolors = new int[4];
		int[] Nnumbers = new int[9];

		for(int i=0; i<5; i++){

			String temp = sc.next();
			char color = temp.charAt(0);
			switch(color){
			case 'R' :
				Ncolors[0]++;
				break;
			case 'B' :
				Ncolors[1]++;
				break;
			case 'Y' :
				Ncolors[2]++;
				break;
			case 'G' :
				Ncolors[3]++;
				break;
			}

			int num = sc.nextInt();
			Nnumbers[num-1]++;
		}



		//System.out.println(Arrays.toString(Ncolors));
		//System.out.println(Arrays.toString(Nnumbers));	


		boolean Flush = checkFlush(Ncolors);
		int Straight = checkStraight(Nnumbers);
		int Fourcard = checkFourcard(Nnumbers);
		int Triple = checkTriple(Nnumbers);
		int Pair = checkPair(Nnumbers, 0);
		int Max = getMax(Nnumbers);


		if(Flush == true && Straight > 0){
			System.out.println(900 + Straight);
		}
		else if(Fourcard > 0){
			System.out.println(800 + Fourcard);
		}
		else if(Triple > 0 && Pair > 0){
			System.out.println(700 + Triple*10 + Pair);
		}
		else if(Flush == true){
			System.out.println(600 + Max);
		}
		else if(Straight > 0){
			System.out.println(500 + Straight);
		}
		else if(Triple > 0){
			System.out.println(400 + Triple);
		}
		else if(Pair > 0 && checkPair(Nnumbers, Pair) > 0){
			System.out.println(300 + checkPair(Nnumbers, Pair)*10 + Pair);
		}
		else if(Pair > 0){
			System.out.println(200 + Pair);
		}
		else{
			System.out.println(100 + Max);

		}


		// do not erase
	}


	public static boolean checkFlush(int[] Ncolors) {

		for(int i=0; i<4; i++){
			if(Ncolors[i]==5){
				return true;
			}
		}

		return false;
	}

	public static int checkStraight(int[] Nnumbers) {

		int Nsuc = 0;
		int num = 0;

		for(int i=0; i<9; i++){
			if(Nnumbers[i] ==1){
				Nsuc ++;
				num = i+1;
			}

			else if( Nnumbers[i] == 0) { 

				Nsuc = 0;	
			}
		}

		if(Nsuc == 5){
			return num; 
		}
				
			//System.out.println(Nsuc);
	
		return 0;
	}

	public static int checkFourcard(int[] Nnumbers) {

		for(int i=0; i<9; i++){
			if( Nnumbers[i] == 4 ){
				return i+1;
			}
		}

		return 0;

	}

	public static int checkTriple(int[] Nnumbers) {

		for(int i=0; i<9; i++){
			if( Nnumbers[i] == 3 ){
				return i+1;
			}
		}

		return 0;


	}

	public static int checkPair(int[] Nnumbers, int j) {

		for(int i=j; i<9; i++){
			if( Nnumbers[i] == 2 ){
				return i+1;
			}
		}

		return 0;

	}


	public static int getMax(int[] Nnumbers) {

		int Nmax = 0;
		for(int i=0; i<9; i++){
			if(Nnumbers[i] > 0){
				Nmax = (i+1);
			}
		}

		return Nmax;
	}

}
