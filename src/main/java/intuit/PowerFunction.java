package intuit;

public class PowerFunction {
	
	public double power(double base, int index){
		// base case
		if(index==0){
			return 1.0;
		}if(index==1){
			return base;
		}
		
		boolean negativeindex = false;
		if(index < 0){
			negativeindex = true;
			index = - index;
		}
		double result = 1.0;
		while(index > 0){
			if(index % 2 == 1){
				result = result * base;
				-- index;
			}else{
				result = base * base;
				index /= 2;
			}
		}
		
		if(negativeindex){
			result = 1.0 / result;
		}
		
		return result;
		
	}
	
	public static void main (String args[]){
		
		PowerFunction pf = new PowerFunction();
		System.out.println(pf.power(2, -2));
	}

}
