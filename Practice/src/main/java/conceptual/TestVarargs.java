package conceptual;

public class TestVarargs {
	
	public static void show(int... x){
		//System.out.println("the values are:" + x.toString());
		for(int s : x){
			System.out.println(s);
		}
	}
	
	static void wide(long x){
		System.out.println(x);
	}
	public static void main(String[] args){
		show(5, 4);
		int l = 1000;
		wide(l);
		
	}

}
