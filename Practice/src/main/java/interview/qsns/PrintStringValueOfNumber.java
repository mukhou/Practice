package interview.qsns;

import java.util.HashMap;
import java.util.Map;

public class PrintStringValueOfNumber {
	static Map<Integer, String> map = new HashMap<Integer, String>();
	
	public static void populateMap(){		
			map.put(0, "Zero");
			map.put(1, "One");
			map.put(2, "Two");
			map.put(3, "Three");
			map.put(4, "Four");
			map.put(5, "Five");
			map.put(6, "Six");
			map.put(7, "Seven");
			map.put(8, "Eight");
			map.put(9, "Nine");
			map.put(10, "Ten");
			map.put(11, "Eleven");
			map.put(12, "Twelve");
			map.put(13, "Thirteen");
			map.put(15, "Fifteen");			
			map.put(20, "Twenty");
			map.put(30, "Thirty");
			map.put(100, "Hundred");
			
		
	}

	public static void printStringValue(Integer n){		
		String str = n.toString();	
		if(str.length() == 2){
			printTwoDigitNumber(n);
		}else if(str.length() == 3){
			printThreeDigitNumbers(n);
		}
		
		
	}
	private static void printThreeDigitNumbers(Integer n) {	
			
		if(n == 100){
			System.out.println(map.get(n));
		}
		String str = n.toString();
		str = str.substring(1);
		int temp = Integer.parseInt(str);
		if((temp > 0 && temp <= 13) || temp == 15){
			System.out.println(map.get(100)+ "and" + map.get(temp));
		}else if(temp >= 14 && temp <= 20){
			int temp1 = temp % 10;
			if(temp1 == 0){
				str = map.get(temp);
				System.out.println(map.get(100) + "and" + str);
			}else if(map.containsKey(temp1)){
				str = map.get(temp1)+"teen";				
				System.out.println(map.get(100) + "and" + str);
			}
		}else if(temp >=20 && temp < 30){
			int temp1 = n % 10;
			if(temp1 == 0){
				str = map.get(temp);
				System.out.println(map.get(100) + "and" + str);
			}else if(map.containsKey(temp1)){
					str = map.get(temp1)+"teen";
					System.out.println(map.get(100) + "and" + map.get(20)+map.get(temp1));
				}
			}
		}
		
		
		
	

	private static void printTwoDigitNumber(Integer n) {
		
		if((n > 0 && n <= 13) || n == 15){
			if(map.containsKey(n)){
				System.out.println(map.get(n));
			}			
		}else if(n >= 14 && n <= 20){
			int temp = n % 10;
			if(temp == 0){
				System.out.println(map.get(n));
			}else if(map.containsKey(temp)){
				System.out.println(map.get(temp)+"teen");
			}
		}else if(n >=20 && n < 30){
			int temp = n % 10;
			if(temp == 0){
				System.out.println(map.get(n));
			}else{
				if(map.containsKey(temp)){
					System.out.println(map.get(20) + map.get(temp));
				}
			}
		}
		else if(n >=30 && n < 40){
			int temp = n % 10;
			if(temp == 0){
				System.out.println(map.get(n));
			}else{
				if(map.containsKey(temp)){
					System.out.println(map.get(30) + map.get(temp));
				}
			}
		}
		
	}
	public static void printNumber(Integer n){
		String s = n.toString();
		//System.out.println(s);
		String sb = "";
		StringBuilder b = new StringBuilder();
		sb = s.substring(0, 1);
		//System.out.println(sb);
		if(Integer.parseInt(sb) == 1){
			b.append("One");			
		}
		sb = s.substring(1, 2);
	}
	public static void main(String[] args) {
		populateMap();
		printNumber(125);
		//printStringValue(529);
		//System.out.println(500/100);

	}

}
