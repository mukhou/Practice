package anything;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anything {

	
	
	public static void main(String[] args) {
		/*Chld c = new Chld();
		c.shoow();
		c.show();
		c.shoow();
*/
		int[][] matr = new int[10][10];
		int[] arr = {2, 6, 3, 4, 7};
		int x = 5;
		System.out.println('A' + x);
        System.out.println((char) ('A' + x));
	}

}

class Prnt{
	int x;
	void show(){
		x = 4;
	}
}

class Chld extends Prnt{
	void shoow(){
		System.out.println(x);
		
	}
	
}