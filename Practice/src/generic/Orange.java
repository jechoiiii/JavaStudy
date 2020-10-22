package generic;

public class Orange {

	private int sugarContent;	// 오렌지의 당도

	Orange(int sugar){
		this.sugarContent = sugar;
	}
	
	public void showSugarContent() {
		System.out.println("오렌지의 당도 : " + sugarContent);
	}
	
}
