package generic;

public class FruitBox<T> {	// T -> Apple 제네릭 클래스

	T fruit;	// Apple fruit
	
	public FruitBox(T fruit) {
		this.fruit = fruit;
	}
	
	public void store(T fruit) {	
		this.fruit = fruit;
	}
	
	public T pullOut() {
		return fruit;
	}
	
}
