package example05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortingTest2 {

//	public static cc 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] data = new Employee[5];
		data[0] = new Employee(1, 5);
		data[1] = new Employee(5, 2);
		data[2] = new Employee(2, 3);
		data[3] = new Employee(4, 1);
		data[4] = new Employee(3, 4);
		
		ArrayList<Employee> list = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			list.add(data[i]);
		}
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
//		System.out.println(Arrays.toString(data));
//		Arrays.sort(
//				data, 
//				new Comparator<Employee>() {
//					@Override
//					public int compare(Employee arg0, Employee arg1) {
//						if (Integer.compare(arg0.rank1, arg1.rank1 == 0) {
//							return Integer.compare(arg0.rank2, arg1.rank1);
//						} else {
//							return Integer.compare(arg0.rank1, arg1.rank2);
//						}
//					}
//		});;
//		Arrays.sort(data);
//		System.out.println(Arrays.toString(data));
	}

}

class Employee implements Comparable<Employee> {
	int rank1;
	int rank2;
	
	public Employee(int rank1, int rank2) {
		this.rank1 = rank1;
		this.rank2 = rank2;
	}

	@Override
	public String toString() {
		return "Employee [rank1=" + rank1 + ", rank2=" + rank2 + "]";
	}

	@Override
	public int compareTo(Employee arg0) {
		return Integer.compare(this.rank1, arg0.rank1);
	}
}