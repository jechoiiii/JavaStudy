package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Person implements Comparable<Person>{

	String name; 
	int age; 
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name+"("+age+")";
	}
	
	@Override
	public int compareTo(Person o) {	// 자동으로 제네릭 type 
//		if(age>o.age) {
//			return 1;	// 양수 반환 : 전달 받은 객체의 값이 작을 때
//		} else if(age<o.age) {
//			return -1;	// 음수 반환 : 전달 받은 객체의 값이 클 때
//		} else {
//			return 0;	// 0 반환 : 전달 받은 객체의 값이 같을 때
//		}
		// return age-o.age; // 오름차순
		return o.age-age; // 내림차순
	}

	public static void main(String[] args) {
		
		TreeSet<Person> tSet = new TreeSet<Person>();
		
		tSet.add(new Person("Yoon", 28));
		tSet.add(new Person("Park", 40));
		tSet.add(new Person("Lee", 10));
		
		Iterator<Person> itr = tSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	
}
