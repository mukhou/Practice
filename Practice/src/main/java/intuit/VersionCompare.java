package intuit;

public class VersionCompare {
	
	public static void main(String args[]) {
		
		String v1 = "1.2.30.112";
		String v2 = "2.12.11.09";
		
		String [] token1 = v1.split("\\.");
		
		
		String [] token2 = v2.split("\\.");
		
		
		
		for(int i = 0; i<4; i++){
			int val1 = Integer.parseInt(token1[i]);
			int val2 = Integer.parseInt(token2[i]);
			
			if(val1 == val2){
				System.out.println("versions are equal");
			}else{
				System.out.println("versions not equal");
			}
				
		}
		
		
		
	}

}
