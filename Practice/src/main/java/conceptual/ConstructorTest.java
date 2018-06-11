package conceptual;

public class ConstructorTest {
	private static ConstructorTest constructorTest;
	

	private ConstructorTest(){
	}
	
	public static ConstructorTest getInstance() {
		if(constructorTest == null){
			return new ConstructorTest();
		}else{
			return constructorTest;
		}
		

	}

}

class Test{
	ConstructorTest test = ConstructorTest.getInstance();
}
