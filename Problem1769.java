package example04;

import java.util.Arrays;
//import java.util.Comparator;
import java.util.Scanner;

public class Problem1769 {
	static int L, C;
	static char[] data;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		data = new char[C];
		
		for (int i = 0; i < C; i++) {
			String temp = sc.next();
			data[i] = temp.charAt(0);
		}

		Arrays.sort(data);
		
		for (int i = 0; i < C; i++) {
			dfs(i, 1, 0, 0, "");
		}
	}
	
	public static void dfs(int current, int depth, int con, int vow, String pwd) {
		// ���� ��� & ���� ���� ���� ���
		pwd += data[current];
		if (data[current] == 'a' || data[current] == 'e' || data[current] == 'i' || data[current] == 'o' || data[current]  == 'u') {
			vow += 1;
		}
		else {
			con += 1;
		}
		
		//2. ����� ��
		for (int i = 0; i < data.length; i++) {
			// ����1: ���ĺ� ����
			// ����2: ����, ���� ����
			// ����3: L ���ڼ�
			if (con >= 2 && vow >= 1 && depth == L) {
				System.out.println(pwd);
				break;
			}
			else {
				//3. �� �� �ִ°�?
				if (current < i) {
					//4. ����
					dfs(i, depth+1, con, vow, pwd);
				}
			}
		}
	}
	
//	public static void compareBack(Character[] data) {
//
//		Arrays.sort(data, new Comparator<Character>() {
//			@Override
//			public int compare(Character arg0, Character arg1) {
//				return Character.compare(arg1, arg0);
//			}
//		});
//	}

}
