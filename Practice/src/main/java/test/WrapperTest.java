package test;

public class WrapperTest {
	public static void main(String args[]){
		
		Integer i1 = 127;
		Integer i2 = 127;
		
		if(i1==i2){
			System.out.println("same objects");
		}
		if(i1.equals(i2)){
			System.out.println("content same");
		}
			
	}

}
