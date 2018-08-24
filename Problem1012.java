package example02;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1012 {
	static int T, N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int [N][M];
			visited = new boolean [N][M];
			
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						if (visited[i][j] == false) {
							dfs(j, i, 1);
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int y, int x, int current) {
		visited[y][x] = true;

		System.out.format("(%d, %d) ¹æ¹®\n", x, y);
		System.out.println(current);
		
		for (int i = 0; i < 4; i++) {
			int targetX = x + dx[i];
			int targetY = y + dy[i];
			
			if (targetX >= 0 && targetX < M && targetY >= 0 && targetY < N) {
				if (map[targetY][targetX] == 1) {
					if (visited[targetY][targetX] == false) {
						dfs(targetY, targetX, current+1);
					}
				}
			}
		}
	}

}
