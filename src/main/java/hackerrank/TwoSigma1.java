package hackerrank;

import java.util.*;

public class TwoSigma1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split("\\s");
        Map<Integer, String> map = new HashMap<>();
        List<String> list = Arrays.asList(strArr);
        List<String> strings = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            try{
                int num = Integer.valueOf(list.get(i));
                numbers.add(num);
                map.put(i, "Number");
            }catch (NumberFormatException e){
                strings.add(list.get(i));
                map.put(i, "String");
            }

        }

        Collections.sort(strings);
        Collections.sort(numbers);

        String[] arr = new String[list.size()];
        int count1 = 0;
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            int pos = entry.getKey();
            String type = entry.getValue();
            if(type.equals("String")){
                arr[pos] = strings.get(count1);
                count1++;
            }else {
                continue;
            }
        }
        int count2 = 0;
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            int pos = entry.getKey();
            String type = entry.getValue();
            if(type.equals("Number")){
                arr[pos] = numbers.get(count2).toString();
                count2++;
            }else {
                continue;
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
