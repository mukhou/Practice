package javanovice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDuplicateWordsFromFIle {
	
	public static Map<String, Integer> getWordCount(String fileName){
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 BufferedReader br = null;
		 try{
			 FileReader fr = new FileReader(fileName);
			  br = new BufferedReader(fr);
			 String line = null;
			 while((line = br.readLine()) != null){
				 String[] tempArray = line.split(" ");
				 for(String s : tempArray){
					 s = s.toLowerCase();
					 if(map.containsKey(s)){
						 map.put(s, map.get(s) + 1);
					 }else{
						 map.put(s, 1);
					 }
				 }
			 }
		 }catch(FileNotFoundException e){
			 e.printStackTrace();
		 }catch(IOException e){
			 e.printStackTrace();
		 }finally{
			 try {
				br.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		 }
		 return map;
		
	}
	public static void main(String[] args) {
		Map<String, Integer> map = getWordCount("E:/Urmi/Java/wrspc_practice_jobs/Practice/src/com/javanovice/abc.txt");
		List<Integer> list = new ArrayList<Integer>(map.values());
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
		
	}
	
	
	

}
