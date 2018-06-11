package goldmansachs;

public class SquareRootInRange {

    //Time complexity: O(log(num))
	public static double Sqrt(double num, double precision) {
		double start = 0;
		double end = num;
		while (true) {
			double midRoot = (start + end) / 2;
			double tempRoot = midRoot * midRoot;
			if (Math.abs(tempRoot - num) == 0) {
				return midRoot;
			} else {
				if (tempRoot > midRoot) {
					end = midRoot;
				} else {
					start = midRoot;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Sqrt(4, 0.0001));

	}

}
