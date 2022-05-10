package collectionsgenericsandstring;

import java.util.*;

class Dogmap {
	public Dogmap(String n) {
		name = n;
	}

	public String name;

	public boolean equals(Object o) {
		if ((o instanceof Dogmap) && (((Dogmap) o).name == name)) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return name.length();
	}
}

class CatMap {
}

enum Pets {
	Dogmap, CatMap, HORSE
}

class MapTest {
	public static void main(String[] args) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("k1", new Dogmap("aiko")); // add some key/value pairs
		m.put("k2", Pets.Dogmap);
		m.put(Pets.CatMap, "CatMap key");
		Dogmap d1 = new Dogmap("clover"); // let's keep this reference

		m.put(d1, "Dogmap key");
		m.put(new CatMap(), "CatMap key");
		//System.out.println(m.get("k1")); // #1
		String k2 = "k2";
		//System.out.println(m.get(k2)); // #2
		Pets p = Pets.CatMap;
		//System.out.println(m.get(p)); // #3
		System.out.println(m.get(d1)); // #4
		//System.out.println(m.get(new CatMap())); // #5
		//System.out.println(m.size()); // #6
		// this changes length of name from 6 to 7
		// thus searching the map using d1 looks in the
		// wrong bucket(index 7)
		d1.name = "magnolia";
		System.out.println(m.get(d1)); // #1
		d1.name = "clover";
		System.out.println(m.get(new Dogmap("clover"))); // #2
		d1.name = "arthur";
		System.out.println(m.get(new Dogmap("clover"))); // #3
	}
}
