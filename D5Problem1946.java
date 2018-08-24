package example01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1946 {
	static int T, N;
	static Employee[] data;
	static ArrayList<Integer> pass;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			
			N = sc.nextInt();
			data = new Employee[N];
			pass = new ArrayList<Integer>();
			
			for (int i = 0; i < N; i++) {
				int rank1 = sc.nextInt();
				int rank2 = sc.nextInt();
				
				data[i] = new Employee(rank1, rank2);
			}
			
			Arrays.sort(data);
			
			pass.add(0);
			for (int i = 1; i < N; i++) {
				if (data[pass.get(pass.size()-1)].rank2 > data[i].rank2) {
					pass.add(i);
				}
			}
			
//			System.out.println();
//			System.out.println("Passed: " + pass);
//
//			for (int i = 0; i < pass.size(); i++) {
//				System.out.print(pass.get(i)+ " ");
//			}
			System.out.println(pass.size());
		}
	}
	
	public static void dfs() {
		
	}
}

class Employee implements Comparable<Employee> {
	int rank1;
	int rank2;
	
	public Employee(int rank1, int rank2) {
		this.rank1 = rank1;
		this.rank2 = rank2;
	}

	@Override
	public String toString() {
		return "Employee [rank1=" + rank1 + ", rank2=" + rank2 + "]";
	}

	@Override
	public int compareTo(Employee arg0) {
		return Integer.compare(this.rank1, arg0.rank1);
	}
}
