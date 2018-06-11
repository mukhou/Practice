package bloomberg;

import java.util.List;

public class FindNumberPair {
    /**
     * [3, 4, 2, 1, 4, 1]
     * [4, 1]
     * @param big
     * @param small
     * @return
     */
    private static boolean findNum(List<Integer> big, List<Integer> small){
        int first = small.get(0);
        int second = small.get(1);
        for(int i = 1; i < big.size(); i++){
            if(big.get(i).equals(second) && big.get(1 -1 ).equals(first)){
                return true;
            }
        }
        return false;

    }

}
