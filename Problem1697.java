package example03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1697 {
	static int N, K;
	static Queue<Integer> queue;
	static int[] visited = new int [2031617];
	// visited 숫자로 박으면 몇번만에 왔는지
	// visited 10,001로 놓으면 됨
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		queue = new LinkedList<Integer>();
		
		queue.add(N);
		visited[N] = 0;
		
		outerloop:
		while (queue.isEmpty() == false) {
			//1. Q에서 꺼내옴
			int current = queue.poll();		
			
			int nav[] = { current-1, current+1, current*2 };
			
			for (int i = 0; i < nav.length; i++) {
				if (nav[i] >= 0) {
					if (visited[nav[i]] == 0) {
						queue.add(nav[i]);
//						System.out.println(nav[i]);
						visited[nav[i]] += visited[current]+1;
						if (nav[i] == K) {
							System.out.println(visited[K]);
//							System.out.println(Arrays.toString(visited));
							break outerloop;
						}
					}
				}
			}
		}
	}

}
