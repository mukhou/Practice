package headfirstdesignpatterns.iterator.compositeiterator;

public class Waitress {
    MenuComponent allManus;

    public Waitress(MenuComponent allManus) {
        this.allManus = allManus;
    }

    public void printMenu(){
        allManus.print();
    }
}
