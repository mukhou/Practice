/* 
User: Urmi
Date: 2/13/2020 
Time: 5:04 PM
*/

package headfirstdesignpatterns.template;

public class BeverageTestDrive {
    public static void main(String[] args){
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        System.out.println("Making tea");
        tea.prepareRecipe();

        System.out.println("*************************");

        System.out.println("Making coffee");
        coffee.prepareRecipe();
    }
}
