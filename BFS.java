package example03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	static int N, M;
	static int[][] map;
	static Queue<Integer> queue;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][M+1];
		queue = new LinkedList<>();
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		for (int y = 0; y < args.length; y++) {
			System.out.println(Arrays.toString(map[y]));
		}
		
		//큐 시작점
		queue.add(1);
		
		while(queue.isEmpty() == false) {
			System.out.println(queue.toString());
			//1. Q에서 꺼내옴.
			int current = queue.poll();
//			//2. 방문체크
//			if (visited[current] == false) {
//			visited[current] = true;
//			System.out.println(current + "방문.");
//			}else{
//				continue;
//			}
			//3. 연결된 길
			for (int i = 1; i <= N; i++) {
				//4. 갈수있는가
				if (map[current][i] == 1 & visited[i] == false) {
					//5. Q에 넣는다.
					//2. 방문체크
					visited[i] = true;					
					queue.add(i);
				}	
			}
		}
		
	}

}
