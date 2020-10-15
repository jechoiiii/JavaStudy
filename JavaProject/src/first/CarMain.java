package first;

public class CarMain {

	public static void main(String[] args) {
		
		// 클래스멤버도 상속의 대상이다. 클래스멤버는 한번만 생성, 자손클래스의 이름으로도 호출이 가능하다. 
		System.out.println(Car.name);
		System.out.println(HybridCar.name);
		System.out.println(HybridWaterCar.name);
		
		Car car1 = new Car(100);
		HybridCar car2 = new HybridCar(100, 200);
		HybridWaterCar car3 = new HybridWaterCar(100, 200, 300);
		
		car3.showCurrentGauge();
		
	}

}	


	class Car {  
		static String name = "CAR";
		int gasolinegauge; 
		
		// Car(){}; 디폴트생성자 자동 
		// 사용자가 직접 생성자 만들어서, 디폴트생성자는 자동으로 만들어지지 않음
		// 생성자가 2개 이상이면, 컴퓨터는 어떤 걸 우선해야하는지 기준이 없다 => 기준을 줘야 함. 
		
		Car(int gasolinegauge){
			this.gasolinegauge = gasolinegauge;
		}
	} 
	
	class HybridCar extends Car {
		int electronicGauge; 		
		
		// HybridCar(){
		// 		super();
		// {
		
		HybridCar(int gasolinegauge, int electronicGauge){
			// 조상 클래스의 멤버를 초기화하는 생성자 호출: 상위클래스 생성자 호출은 반드시 *첫번째* 문장에
			super(gasolinegauge);
			// 새롭게 정의한 클래스의 멤버를 초기화
			this.electronicGauge = electronicGauge;	
		}
		
	} 
	
	class HybridWaterCar  extends HybridCar { // HybridWaterCar 는 HybirdCar만 신경쓰면 됨
		int waterGauge;  
		
		// HybridWaterCar(){
		//		super();
		// }
		
		HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge){
			super(gasolinegauge, electronicGauge);
			this.waterGauge = waterGauge;
		}
		
		
		public void showCurrentGauge() {
				System.out.println("잔여 가솔린 : " + gasolinegauge);  
				System.out.println("잔여 전기 : " + electronicGauge);   
				System.out.println("잔여 water : " + waterGauge);  
			} 

}
		
		
		
		
		


