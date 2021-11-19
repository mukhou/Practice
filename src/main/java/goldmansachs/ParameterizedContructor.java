package goldmansachs;

public class ParameterizedContructor {
	
	int[] arr;
	public ParameterizedContructor(int[] arr){
		this.arr = arr;
		
	}
	public static void main(String[] args) {
		ParameterizedContructor[] parArr = {new ParameterizedContructor(new int[1])};

	}

}
