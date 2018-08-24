package example04;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10819 {
	static int N;
	static boolean visited[];
	static int history[];
	// [true, true, true, true, true, true]
	static int map[];
	static int max;
	static int result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();

		visited = new boolean[N];
		history = new int[N];
		map = new int[N];
		
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(sc.next());
		}
		
		if (N <= 8 && N >=3) {
			for (int i = 0; i < N; i++) {
				dfs(i, 1);
				visited = new boolean [N];
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int current, int depth) {
		visited[current] = true;
		history[current] = depth;
		if (depth == N) {
//			System.out.println(Arrays.toString(visited));
			result=0;
			for (int i = 0; i < N-1; i++) {
				result += Math.abs(map[history[i]-1] - map[history[i+1]-1]);
			}
//			System.out.println(result);
			if (max <= result) {
				max = result;
			}
			return;
		}
		//2. 연결된 길
		for (int i = 0; i < N; i++) {
			//3. 갈 수 있는 길
			if (visited[i] == false) {
				//4. 간다
				dfs(i, depth+1);
				visited[i] = false;
				history[i] = 0;
			}
		}
	}
}
