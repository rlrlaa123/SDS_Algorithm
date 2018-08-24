package example04;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	static Set<Integer> set;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		set = new HashSet<>();
		
		set.add(1);
		set.add(1);
		set.add(1);
		
		System.out.println(set);
		System.out.println(set.contains(2));
	}

}
