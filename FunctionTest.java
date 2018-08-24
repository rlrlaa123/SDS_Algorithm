package example02;

public class FunctionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = pow(2, 3);
		System.out.println(result);
	}

	// a를 b번 더해라
	public static int sum(int a, int b) {
		if (b == 1) {
			return a;
		} else {
			return a + sum(a, b-1);
		}
	}
	
	public static int pow(int a, int b) {
		if (b == 1) {
			return a;
		} else {
			return a * pow(a, b-1);
		}
	}
}
