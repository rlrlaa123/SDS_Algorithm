package example01;

public class arraySample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };
		
		int n=3;
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {		
				System.out.print(arr[i][k] + " ");
			}	
			
			System.out.println();
		}	
		
	}

}
