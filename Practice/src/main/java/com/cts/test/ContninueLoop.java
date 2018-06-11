package com.cts.test;

public class ContninueLoop {


	public static void main(String[] args) {
		
		int i,j;
		
		for(i=1; i<=2; i++){
			
			for(j=1; j<=2; j++){
				
				if(i==j){
					continue;
					
				}
				System.out.print(i);
				System.out.println(j);
				
			}
		}

	}

}
