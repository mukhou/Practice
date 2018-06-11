package interview.qsns;

public class SortThreeNumbers {

	public void sort(int a, int b, int c) {
		int x, y, z, minOf2, maxOf2;
		
		if(a<b){
			minOf2 = a;
			maxOf2 = b;
		}else{
			maxOf2 = a;
			minOf2 = b;
		}
		
		if(minOf2 > c){
			x = c;
			y = minOf2;
			z = maxOf2;
		}else{
			x = minOf2;
			if(c < maxOf2){
				y = c;
				z = maxOf2;
			}else{
				y = maxOf2;
				z = c;
			}
		}
		System.out.println("minimum is = "+ x);
		System.out.println("medium is = "+ y);
		System.out.println("maximum is = "+ z);
	}
	public static void findMinMax(int a, int b, int c){
		int minOf2, maxOf2;
		if(a < b){			
			minOf2 = a;
			maxOf2 = b;
		}else{
			maxOf2 = a;
			minOf2 = b;
		}
		if(minOf2 > c){
			System.out.println("minimum i s" + c);
			System.out.println("medium is " + minOf2);
			System.out.println("maximum is " + maxOf2);
			
		}else{
			System.out.println("minimum is " + minOf2);
			if(c < maxOf2){
				System.out.println("medium is " + c);
				System.out.println("maximum is " + maxOf2);
			}else{
				System.out.println("medium is " + maxOf2);
				System.out.println("maximum is " + c);
			}
		}
	}

	public static void main(String[] args) {
		
		SortThreeNumbers s = new SortThreeNumbers();
		//s.sort(11, 2, 14);
		findMinMax(11, 2, 14);

	}

}
