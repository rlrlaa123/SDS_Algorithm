package example04;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1987 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] checked;
	static boolean[] alphabet;
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char [R][C];
		visited = new boolean [R][C];
		checked = new int [R][C];
		alphabet = new boolean [26];
		
		Position a = new Position(0,0,1);
		
		for (int i = 0; i < R; i++) {
			String temp = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

//		visited[0][0] = 1;
		dfs(a);
		int max = 0;
		for (int j = 0; j < R; j++) {
			for (int i = 0; i < C; i++) {
				if (max <= checked[j][i]) {
					max = checked[j][i];
				}
			}
		}
		for (int i = 0; i < args.length; i++) {
		}
		System.out.println(max);
	}
	
	public static void dfs(Position current) {
		int distance = current.distance;
		//1. 방문체크
		checked[current.y][current.x] = current.distance;
		visited[current.y][current.x] = true;
		//조건1: 알파벳 기록
		alphabet[map[current.y][current.x]-65] = true;
		//2. 연결된 길
		for (int i = 0; i < 4; i++) {
			int targetX = current.x + dx[i];
			int targetY = current.y + dy[i];
			
			//3. 갈 수 있는 길
			if (targetX >= 0 && targetX < C && targetY >= 0 && targetY < R) {
				if (checked[targetY][targetX] == 0) {
					//조건1: 이미 간 알파벳인지 체크
					if (alphabet[map[targetY][targetX]-65] == false) {
						if (visited[targetY][targetX] == false) {
							//4. 간다
							dfs(new Position(targetY, targetX, distance+1));
							alphabet[map[targetY][targetX]-65] = false;
							visited[targetY][targetX] = false;
						}
					}
				}
				
			}
			
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
