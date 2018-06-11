package conceptual;

//IMPORTANT
//check: http://stackoverflow.com/questions/9524025/why-inner-class-can-override-final-method
public class FinalClass {

	private final void touchMe() {
        System.out.println("super::I am not overridable!");
    }
	private class InnerClass extends FinalClass{
		
		private void touchMe(){
			super.touchMe();
			System.out.println("sub::You suck! I overrided you!");
		}
	}
	
	public static void main(String[] args) {
		FinalClass f = new FinalClass();
		FinalClass.InnerClass in = f.new InnerClass();
		in.touchMe();

	}

}
