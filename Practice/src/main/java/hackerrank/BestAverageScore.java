package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Coderpad: given a list of student scores, find the best average score.
 * Each student may have more than one score in the list.
 * Example:
 * Input:
 * [ ["bobby", "87"],
 *   ["charles", "100"],
 *   ["eric", "64"],
 *   ["charles", "22"] ]
 *
 *  Output: 87
 */

public class BestAverageScore {
    public static Integer bestAverageScore(String[][] scores){
        if(scores.length == 0){
            return 0;
        }

        //build a hashmap of students to list of scores
        Map<String, List<Integer>> studentToScores = new HashMap<>();
        for(String[] pair : scores){
            List<Integer> scoreList = studentToScores.get(pair[0]);
            if(scoreList == null){
                scoreList = new ArrayList<>();
                scoreList.add(Integer.parseInt(pair[1]));
                studentToScores.put(pair[0], scoreList);
            }else {
                scoreList.add(Integer.parseInt(pair[1]));
            }
        }

        //get average and max
        double max = -Double.MAX_VALUE;
        for(List<Integer> scoreList : studentToScores.values()){
            // VERY GOOD EXAMPLE OF JAVA 8 REDUCTION TECHNIQUE
            // WHERE WE HAVE A LIST OF NUMBERS AND WE WANT TO REDUCE IT TO A NUMBER
            Integer sum = scoreList.stream().reduce(Integer::sum).get();
            double avg = sum/scoreList.size();
            max = Math.max(avg, max);

        }


        return (int)Math.floor(max);
    }

    public static void main(String[] args){
        String[][] arr = {
                {"bobby", "87"},
                { "charles", "100"},
                {"eric", "64"},
                {"charles", "22"}
        };
        System.out.println(bestAverageScore(arr));

    }
}
