package example02;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2606 {
	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static int[] sequence;
	static int counter;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int [N + 1][N + 1];
		visited = new boolean[N + 1];
		counter = 1;
		sequence = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		dfs(1);
		
		counter= 0;
		for (int i = 1; i < sequence.length; i++) {
			if (sequence[i] != 0) {

				counter+=1;
			}
		}
		
		System.out.println(counter-1);
	}
	
	public static void dfs(int node) {
//		System.out.println(node + "방문.");
		sequence[node] = counter;
//		System.out.println(Arrays.toString(sequence));
		//1. 방문기록
		visited[node] = true;
		//2. 연결된 길
		for (int i = 1; i <= N; i++) {
			if (map[node][i] == 1) {
				//3. 갈수있는가?
				if (visited[i] == false) {
					//4. 간다
					dfs(i);
				}
			}
		}
		
	}
}
