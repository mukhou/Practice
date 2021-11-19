package goldmansachs;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool implements Pool {
	// singleton pattern
	private static List<Connection> pool = null;
	private static int available = 0;

	private ConnectionPool() {
	}

	public  Connection get() {
		if (pool == null) {
			pool = new ArrayList<Connection>();
			for (int i = 0; i < 3; i++) {
				pool.add(new Connection());
				available++;
			}
		}
		if (pool.size() > 0) {
			available--;
			return pool.remove(available);
		} else {
			return null;
		}
	}

	public  void put(Connection c) {
		pool.add(c);
		available++;
	}

}
