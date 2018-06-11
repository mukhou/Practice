package intuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class GenreSort implements Comparator<DVDInfo>{
	public int compare(DVDInfo d1, DVDInfo d2){
		return d1.getGenre().compareTo(d2.getGenre());
	}
}

class DVDInfo implements Comparable<DVDInfo>{
	String title;
	String genre;
	String leadActor;

	DVDInfo(String t, String g, String a) {
		title = t;
		genre = g;
		leadActor = a;
	}

	public String toString() {
		return title + " " + genre + " " + leadActor + "\n";
	}
	
	public int compareTo(DVDInfo d){
		return this.title.compareTo(d.getTitle());
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getGenre(){
		return genre;
	}
}

public class TestDVD {

	public static void main(String args[]) {
		
		List<DVDInfo> dvdlist = new ArrayList<DVDInfo>();
		String d1 = "Donnie Darko/sci-fi/Gyllenhall, Jake";
		String[] token = d1.split("/");
		DVDInfo info1 = new DVDInfo(token[0], token[1], token[2]);
		DVDInfo info2 = new DVDInfo("Home Alone", "comedy", "Hugh");
		DVDInfo info3 = new DVDInfo("Gladiator", "action", "Russel");
		dvdlist.add(info1);
		dvdlist.add(info2);
		dvdlist.add(info3);
		//System.out.println(info1.toString());
		GenreSort gs = new GenreSort();
		// passing the comparator sorts by genre
		Collections.sort(dvdlist, gs);
		System.out.println(dvdlist);
		// not using the comparator sorts by title
		Collections.sort(dvdlist);
		System.out.println(dvdlist);
		
		

	}

}
