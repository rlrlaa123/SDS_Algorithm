package example03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2178 {
	static int N, M;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Queue<Position> queue;
	static int[][] map;
	static int[][] visited;
	
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		queue = new LinkedList<Position>();
		Position a = new Position(0,0,1);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new int[N][M];
				
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {
				if (temp.charAt(j) == '1') {
					map[i][j] = 1;
				} else {
					map[i][j] = 0;
				}
				visited[i][j] = 0;
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		queue.add(a);
		visited[0][0] = 1;
		
		while(queue.isEmpty() == false) {
			//1. Q에서 꺼내옴.
			Position current = queue.poll();

//			if (current.distance < distance) {
//				distance = current.distance;
//			}
			if (current.x == M-1 && current.y == N-1) {
				result = current.distance;
				System.out.println(result);
				break;
			}
//			System.out.format("(%d, %d) 방문\n", current.y, current.x);
//			System.out.println(current);
			//2. 연결된 길
			for (int i = 0; i < 4; i++) {
				int targetX = current.x + dx[i];
				int targetY = current.y + dy[i];
				int distance = current.distance;
				//3. 갈 수 있는가?
				if (targetX >= 0 && targetX < M && targetY >= 0 && targetY < N) {
					if (map[targetY][targetX] == 1) {
						if (visited[targetY][targetX] == 0) {
							//5. Q에넣는다.
							queue.add(new Position(targetY, targetX, distance+1));
							//2. 방문체크
							visited[targetY][targetX] += visited[current.y][current.x] + 1;
						}
					}
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
	}
}
//class Position {
//	int x;
//	int y;
//	int distance;
//	
//	public Position(int y, int x, int distance) {
//		this.x = x;
//		this.y = y;
//		this.distance = distance;
//	}
//
//	@Override
//	public String toString() {
//		return "Position [x=" + x + ", y=" + y + ", disatnce=" + distance + "]";
//	}
//	
//}
