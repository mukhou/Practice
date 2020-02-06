package headfirstdesignpatterns.builder;

public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts(NutritionBuilder builder) {
        servingSize = builder.getServingSize();
        servings = builder.getServings();
        calories = builder.getCalories();
        fat = builder.getFat();
        sodium = builder.getSodium();
        carbohydrate = builder.getCarbohydrate();

    }

    public static void main(String[] args){
        NutritionFacts nutritionFacts = new NutritionBuilder(12, 2).build();
        NutritionFacts nutritionFacts1 = new NutritionBuilder(12, 4).calories(8).build();
    }

}
