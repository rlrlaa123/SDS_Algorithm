package example01;

import java.util.Scanner;

public class problem1652 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		char[][] map;
		
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		sc.nextLine();
	//	System.out.println();
	//	System.out.println("n : " + n);

		map = new char[n][];
		for (int i=0; i<n; i++){
				String temp = sc.nextLine();
				map[i] = temp.toCharArray(); //Change string to char array
		}
		

		int indic_calc;
		int SleepX=0;
		int SleepY=0;
		
		// Counting sleeping position along x-axis
		for(int i=0; i<n; i++){
			indic_calc = 0;
			for(int j=0; j<n; j++){	
				if(map[i][j] == '.'){
					indic_calc += 1;
				}
				else {
					if(indic_calc >= 2){
						SleepX += 1;
						indic_calc = 0;
					}
				}

			}
			
			if(indic_calc >= 2){
				SleepX += 1;
			}
		}

		//System.out.println("Total Sleeping position number X : " + SleepX);

	//	System.out.println("=============== y - axis =================");
	//	System.out.println();
		
		// Counting sleeping position along y-axis

		
		// Counting sleeping position along x-axis
		for(int i=0; i<n; i++){
			indic_calc = 0;
			for(int j=0; j<n; j++){	
				if(map[j][i] == '.'){
					indic_calc += 1;
					System.out.println(indic_calc);
				}
				
				else {
					if(indic_calc >= 2){
						SleepY += 1;
					}
					indic_calc = 0;
					System.out.println(indic_calc);

				
				}

			}
			
			if(indic_calc >= 2){
				SleepY += 1;
			}
			System.out.println("SleepY : " + SleepY);
			System.out.println();
		}

		
		//System.out.println("Total Sleeping position number Y : " + SleepY);

		System.out.print(SleepX + " " + SleepY);
	}

}
