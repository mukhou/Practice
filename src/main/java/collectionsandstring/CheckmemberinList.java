package collectionsandstring;

import java.util.ArrayList;
import java.util.List;

public class CheckmemberinList {

	private String memberExists(List<String> lst){
		String s = "";
		if(lst.contains("def")){
			s = "true";
		}else{
			s = "false";
		}
		
		System.out.println(s);
		return s;
		
	}
	public static void main(String[] args) {
		List<String> strLst = new ArrayList<String>();
		strLst.add("abc");
		strLst.add("def");
		strLst.add("ghi");
		
		CheckmemberinList chk = new CheckmemberinList();
		chk.memberExists(strLst);

	}

}
