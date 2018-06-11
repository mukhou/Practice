package conceptual;

public class TestPrivate {
    public static void main(String[] args){
        MyParent myParent = new MyParent();
        System.out.println(myParent.getA());
        MyChild myChild = new MyChild();
        System.out.println(myChild.getA());
    }

    private static class MyParent{
        private int a = 0;
        public int getA(){
            return a;
        }
    }
    private static class MyChild{
        private int a = 1;
        public int getA(){
            return a;
        }
    }
}

