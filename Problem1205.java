package example01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem1205 {
	static int N, score, P;
	static ArrayList<Score> ranking;
	static ArrayList<Integer> data;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		score = sc.nextInt();
		P = sc.nextInt();
		
		ranking = new ArrayList<>();
		data = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			data.add(temp);
		}
		
		data.add(score);
		Collections.sort(data, Collections.reverseOrder());

		int lastIndex = data.lastIndexOf(score);
		if (lastIndex>=P) {
			System.out.println(-1);
		} else {
			System.out.println(data.indexOf(score)+1);
		}
		
//		//조건문0.N이 0일 경우
//		if (N == 0) {
//			System.out.println(1);
//		}
//		//조건문1.중복점수일 경우
//		else if (containsScore(data, score)) {
//			data.add(new Score(0, score));
//			Collections.sort(data, Collections.reverseOrder());
//			
//			
//			
//			int firstIndexOfScore = getFirstIndexOfScore(data, score);
//			//조건문2.순위권에 들지 못할 경우
//			if (firstIndexOfScore >= P) {
//				System.out.println(-1);
//			}
//			//조건문2.순위권에 들었을 경우
//			else {
//				//조건문3.1등 일 때,
//				if (firstIndexOfScore == 0) {
//					System.out.println(1);
//				}
//				//조건문3.1등이 아닐 때,
//				else {
//					int rankCounter = 1;
//					for (int i = 1; i < data.size(); i++) {
//						//조건문4.중복 순위가 있을 경우
//						if (data.get(i-1).score == data.get(i).score) {
//							data.get(i).setRank(rankCounter);
//						}
//						//조건문4.중복 순위가 없을 경우
//						else {
//							rankCounter+=1;
//							data.get(i).setRank(rankCounter);
//						}
//					}
//					System.out.println(data);
//					System.out.println(data.get(firstIndexOfScore-1).rank);
//				}
//			}
//		}
//		//조건문1.중복점수가 아닐 경우
//		else {
//			data.add(new Score(0, score));
//			Collections.sort(data);
//			
//			int firstIndexOfScore = getFirstIndexOfScore(data, score);
//			//조건문2.순위권에 들지 못할 경우
//			if (firstIndexOfScore >= P) {
//				System.out.println(-1);
//			}			
//			//조건문2.순위권에 들었을 경우
//			else {
//				//조건문3.1등 일 때,
//				if (firstIndexOfScore == 0){
//					System.out.println(1);
//				}
//				//조건문3.1등이 아닐 때,
//				else {
//					int rankCounter = 1;
//					for (int i = 1; i < data.size(); i++) {
//						//조건문4.중복 순위가 있을 경우
//						if (data.get(i-1).score == data.get(i).score) {
//							data.get(i).setRank(rankCounter);
//						}
//						//조건문4.중복 순위가 없을 경우
//						else {
//							rankCounter+=1;
//							data.get(i).setRank(rankCounter);
//						}
//					}
//					System.out.println(data);
//					System.out.println(data.get(firstIndexOfScore-1).rank+1);
//				}
//			}
//			
//		}
	}
	
	public static boolean containsScore(final List<Score> list, final int num) {
	    return list.stream().filter(o -> o.getScore().equals(num)).findFirst().isPresent();
	}
	
	public static int getFirstIndexOfScore(final List<Score> list, final int num) {
		for (int i = list.size()-1; i >= 0; i--) {
			if (list.get(i).score == num) {
				return i;
			}
		}
		return -1;
	}
}

class Score implements Comparable<Score> {
	int rank;
	int score;
	
	public Score(int rank, int score) {
		this.rank = rank;
		this.score = score;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public Object getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}
	
	@Override
	public String toString() {
		return "Score [rank=" + rank + ", score=" + score + "]";
	}
	
	@Override
	public int compareTo(Score arg0) {
		return Integer.compare(arg0.score, this.score);
	}
}
