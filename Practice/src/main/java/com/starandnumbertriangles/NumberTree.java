package com.starandnumbertriangles;
/**
 * Abhishek's program. from Dev C++
 * Numbertree.cpp
 * @author Atithi
 *
 */

public class NumberTree {
	
	public static void main(String[] args){
		
		int i,j,k,l,m,n,o;
	    char c = 0;
	    do
	    {
	        System.out.println("Please enter a number less than 25: ");
	        n = 3;
	        for(i=1;i<=n;i++)
	        {
	            if (i>=9)
	                {
	                    for(j=1;j<=(n-i);j++)
	                       {
	                    	System.out.println("  ");
	                       }
	                }
	                       else
	                         {  for(j=1;j<=(n-i);j++)
	                            {
	                        	 System.out.println(" ");
	                              }
	                              for(o=1;o<=(n-9);o++)
	                            {
	                            	  System.out.println(" ");
	                              }
	                              }
	            for(k=i;k>1;k--)
	            {
	            	System.out.println(k);
	            }
	            for(l=1;l<=i;l++)
	            {
	            	System.out.println(l);
	            }
	            System.out.println("\n");
	        }
	        System.out.println("Do you want to continue ? (y/n)");
	       
	    }while(c!= 'n');                     

		
	}

}



