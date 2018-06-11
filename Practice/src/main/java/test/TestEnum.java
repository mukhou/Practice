package test;


enum CoffeeSize{
	BIG(8), 
	HUGE(10), 
	OVERWHELMING(10){
		
		public String getLidCode(){
			return "A";
		}
	};
	
	CoffeeSize(int ounces){
		this.ounces = ounces;
	}
	private int ounces;
	
	public int getOunces(){
		return ounces;
	}
	
	public String  getLidCode(){
		return "B";
	}
}
public class TestEnum {

	CoffeeSize size;
	public static void main(String[] args) {
		TestEnum te1 = new TestEnum();
		te1.size = CoffeeSize.BIG;		
		System.out.println(te1.size.getLidCode());
		
		TestEnum te2 = new TestEnum();
		te2.size = CoffeeSize.OVERWHELMING;
		System.out.println(te2.size.getLidCode());
		System.out.println(te2.size.getOunces());
		System.out.println(CoffeeSize.BIG.name());
		System.out.println(CoffeeSize.BIG.name());

	}

}
