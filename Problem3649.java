package example01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Problem3649 {
	static int x, n;
	static int[] l;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt() * 10000000;
		n = sc.nextInt();
		
		l = new int[n];
		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
		}
		int counter = 0;
		Arrays.sort(l);
		System.out.println(Arrays.toString(l));
		for (int i= 0; i < n/2; i++) {
			int temp = l[i] + l[n-i-1];
			if (temp == x) {
				int result = Math.abs(l[n-i-1]-l[i]);
				if (max <= result) {
					System.out.println(result);
					max = result;
				}
			}
		}
	}

}
