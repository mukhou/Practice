package goldmansachs;

public class TestStringBuffer {
	
	StringBuffer sb ;

	public static void show(StringBuffer sb){
		sb = new StringBuffer("def");
	}
	public static void main(String[] args) {
		StringBuffer sb;
		
		sb = new StringBuffer("abc");
		show(sb);
		System.out.println(sb);
		TestStringBuffer t = new TestStringBuffer();
		t.sb = new StringBuffer("mno");
		System.out.println(t.sb);

	}

}
