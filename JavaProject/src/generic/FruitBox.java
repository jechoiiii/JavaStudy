package generic;

	public class FruitBox<T> {	// T -> Apple
	
		T fruit; // Apple fruit
	
		public FruitBox(T fruit) {	// public FruitBox(Apple fruit)
			this.fruit = fruit;
		}

		public void store(T fruit) {	// public void store(Apple fruit)
			this.fruit = fruit;
		}
		
		public T pullOut() { // public Apple pullOut()
			return fruit;
		}

		
		
//	public class FruitBox {
//
//		Object fruit; 
//	
//		public void store(Object fruit) {
//			this.fruit = fruit;
//		}
//		
//		public Object pullOut() {
//			return fruit;
//		}
	
}
