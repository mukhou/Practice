package goldmansachs;

public interface Pool {
	public Connection get();
	public void put(Connection c);

}
