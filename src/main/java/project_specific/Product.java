/* 
User: Urmi
Date: 1/22/2020 
Time: 4:41 PM
*/

package project_specific;

public class Product {

    private String cusip;

    public String getCusip() {
        return cusip;
    }

    public String getMergeKey(){
        return cusip;
    }
}
