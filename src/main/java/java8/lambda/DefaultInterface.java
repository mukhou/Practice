package java8.lambda;

public class DefaultInterface {

    public static void main (String args[]){
        Formula f = new Formula() {
            @Override
            public double calculate(int a) {
                System.out.println("in calculate method");
                return sqrt(a);
            }
        };
        System.out.println(f.calculate(49));
        System.out.println(f.sqrt(9));

    }
}
 interface Formula {
    double calculate(int a);
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}

