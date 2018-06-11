package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMovie {
    class Movie{
        Movie(String name, int duration){
            this.name = name;
            this.duration = duration;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public boolean equals(Object o){
            if(o.equals(this)){
                return true;
            }
            if(o instanceof Movie){
                Movie m = (Movie) o;
                if(m.duration == this.duration && m.name.equals(this.name)){
                    return true;
                }
            }
            return false;
        }

        private String name;
        private int duration;

    }
    public static void main(String[] args){
        List<Movie> list = new ArrayList<>();
        list.add(new TestMovie().new Movie("ddlj", 3));
        list.add(new TestMovie().new Movie("kkhh", 2));
        list.add(new TestMovie().new Movie("mogli", 1));
        list.add(new TestMovie().new Movie("pkdk", 4));
        list.add(new TestMovie().new Movie("paakeezah", 4));
        list.add(new TestMovie().new Movie("umraao", 3));
        int flightDuration = 7;
        findMoviePair(flightDuration, list);

    }

    private static void findMoviePair(int flightDuration, List<Movie> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j).duration + list.get(i).duration == flightDuration){
                    System.out.println(list.get(i).name + " " +  list.get(j).name);
                }
            }
        }
    }
}
