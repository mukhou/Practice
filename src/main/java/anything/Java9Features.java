/* 
User: Urmi
Date: 12/23/2019 
Time: 8:23 PM
*/

package anything;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java9Features {

    public static void main(String[] args){
        Map emptyImmutableMap = Map.of();
        List list = List.of();
        list.stream().flatMap(o -> Stream.ofNullable(o)).collect(Collectors.toList());
    }
}
