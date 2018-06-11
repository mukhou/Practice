package javanovice;

public class ArmstrongNumber {
	
	public static void checkArmstrong(int n){
		
		int temp = n;
		int d, cube_val = 1, sum = 0;
		while(temp > 0){
			d = temp % 10;
			cube_val = (int)Math.pow(d, 3);
			sum = sum + cube_val;
			temp /= 10;
		}
		if(sum == n){
			System.out.println("ArmstrongNumber");
		}else{
			System.out.println("Not ArmstrongNumber");
		}
	}

	
	public static void main(String[] args) {
		
		
		checkArmstrong(371);
		

	}

}
