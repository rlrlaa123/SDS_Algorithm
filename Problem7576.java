package example03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem7576 {
	static int N, M;
	static int[][] map;
	static Queue<Position> queue;
	static int[][] visited;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int [N][M];
		queue = new LinkedList<Position>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(sc.next());
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		visited = new int [N][M];
		//0. 시작위치 선정
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					queue.add(new Position(i, j, 1));
					visited[i][j] = 1;
				}
				if (map[i][j] == -1) {
					visited[i][j] = -1;
				}
			}
		}
		

		while(queue.isEmpty() == false) {
			//1. Q에서 꺼내옴
			Position current = queue.poll();
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));	
//			}
			//3. 연결된 길
			for (int i = 0; i < 4; i++) {
				int targetX = current.x + dx[i];
				int targetY = current.y + dy[i];
				
				//4. 갈 수 있는 길
				if (targetX >= 0 && targetX < M && targetY >=0 && targetY < N) {
					if (map[targetY][targetX] != -1 && map[targetY][targetX] == 0 && visited[targetY][targetX] == 0) {
						//5. Q에 넣는다.
						queue.add(new Position(targetY, targetX, current.distance+1));
						//2. 방문체크
//						map[targetY][targetX] = current.distance+1;
						if (visited[targetY][targetX] == 0) {
							visited[targetY][targetX] = current.distance;
//							System.out.println(current + "방문.");
						}
					}
				}
			}
		}
		int max = 0;
		boolean no = false;
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0) {
					no = true;
				}
				if (max <= visited[i][j]) {
					max = visited[i][j];
				}
				if (map[i][j] == 0) {
					count +=1;
				}
//				System.out.print(visited[i][j]);
			}
//			System.out.println();
		}
		if (no) {
			System.out.println(-1);
		} 
		else if (count==0) {
			System.out.println(0);
		}	
		else {
			System.out.println(max);
		}
	}
}
class Position {
	int x;
	int y;
	int distance;
	
	public Position(int y, int x, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", distance=" + distance + "]";
	}
}