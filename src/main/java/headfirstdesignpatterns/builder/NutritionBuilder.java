/* 
User: Urmi
Date: 2/5/2020 
Time: 6:41 PM
*/

package headfirstdesignpatterns.builder;

public class NutritionBuilder {
    //required params
    private final int servingSize;
    private final int servings;

    // Optional parameters - initialized to default values
    private int calories = 0;
    private int fat = 0;
    private int carbohydrate = 0;
    private int sodium = 0;

    public NutritionBuilder(int servingSize, int servings){
        this.servingSize = servingSize;
        this.servings = servings;
    }

    public NutritionBuilder calories(int val){
        calories = val;
        return this;
    }

    public NutritionBuilder fat(int val){
        fat = val;
        return this;
    }

    public NutritionBuilder carbohydrate(int val){
        carbohydrate = val;
        return this;
    }

    public NutritionBuilder sodium(int val){
        sodium = val;
        return this;
    }

    public NutritionFacts build(){
        return new NutritionFacts(this);
    }


    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public int getSodium() {
        return sodium;
    }
}
