package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		// Map : key-value 형식으로 저장하는 객체
		// HashMap<K,V>
		// 참조 : V get(K key)

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		// 요소 추가 : put(T e)	// 제네릭 element // 값을 저장하고, 필요할 때 가져오는 것
		map.put(new Integer(1), "일번");
		map.put(2, "이번");
		map.put(3, "삼번");
	
		// 참조 : V get(K key)
		System.out.println("1번 학생의 이름 : "+ map.get(1));
		System.out.println("2번 학생의 이름 : "+ map.get(2));
		System.out.println("3번 학생의 이름 : "+ map.get(3));
		
		// NavigableSet<Key Type>
		Set<Integer> set = map.keySet();
		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()) {
			int key = itr.next();
			System.out.println(key+"번 학생의 이름 : "+ map.get(key));
				// itr.next() 두 번 못쓰는 이유 : 이미 한번 참조되어 두번째는 null로 나옴.
		}
		
	}

}
