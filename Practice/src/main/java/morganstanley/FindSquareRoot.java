package morganstanley;

public class FindSquareRoot {

	// follow method in goldmansachs folder
	public static double Sqrt(int num) {
		//base case
		if(num == 0 || num == 1){
			return num;
		}
		int start = 1, end = num, ans = 0;
		while(start <= end){
			int mid = (start + end) / 2;
			//num is a perfect square
			if(mid * mid == num){
				return mid;
			}else {
				if(mid * mid < num){
					start = mid + 1;
					ans = mid;
				}else {
					end = mid - 1;
				}
			}

		}
		return ans;
	}
	
	public static void main(String[] args) {
		/*int num = 48;
		int guess = 1;
		while(0.0001 < Math.abs(guess * guess - num)){
		    guess = (guess + num / guess) / 2;		    
		}
		System.out.println(Integer.toString(guess));*/
		System.out.println(Sqrt(48));
	}

}
