/**
 * Design a immutable object with Date object as a member attribute.
 */

package conceptual;

import java.util.Date;

public class ImmutableDate {

	private final Date date;
	public ImmutableDate(Date date){
		this.date = new Date();
	}
	
	public Date getDate(){
		return this.date;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
