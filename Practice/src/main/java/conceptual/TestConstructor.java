package conceptual;

class Clothing{
	Clothing(String s){
		System.out.println("This is a clothing store.");
	}
}

//Since you have a agument based constructor in the super class,
// you HAVE TO HAVE an IDENTICAL argument based constructor in your subclass as well
class TShirt extends Clothing{
	int x = 1;

	TShirt(String s) {
		super(s);
		x ++;
		
	}
	
	
	
	
	
}

public class TestConstructor {

}
