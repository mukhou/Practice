package matrix;

import java.util.Arrays;



public class Statistics {
	double[] data;
    double size;    

    public Statistics(double[] data) 
    {
        this.data = data;
        size = data.length;
    }   

    double getMean()
    {
        double sum = 0.0;
        for(double a : data)
            sum += a;
            return sum/size;
    }

        double getVariance()
        {
            double mean = getMean();
            double temp = 0;
            for(double a :data)
                temp += (mean-a)*(mean-a);
                return temp/size;
        }

        double getStdDev()
        {
            return Math.sqrt(getVariance());
        }

        public double median() 
        {
               double[] b = new double[data.length];
               System.arraycopy(data, 0, b, 0, b.length);
               Arrays.sort(b);

               if (data.length % 2 == 0) 
               {
                  return (b[(b.length / 2) - 1] + b[b.length / 2]) / 2.0;
               } 
               else 
               {
                  return b[b.length / 2];
               }
        }
        
        public static void main(String[] args) {
    		//double[] arr = {1, 3, 5, 7, 9};
        	double[] arr = {2, 4, 6, 8, 10};
    		Statistics s = new Statistics(arr);
    		System.out.println(s.getMean());
    		System.out.println(s.getStdDev());
    		

    	}


}
