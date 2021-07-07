package hr.truenorth.TrueNorth.Util;

import java.sql.Timestamp;

import hr.truenorth.TrueNorth.Model.Rental;

public class RentalDurationUtil {

	public static boolean rentExpired(Rental rental) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		if(rental.getDateUntil().compareTo(ts) <= 0)
			return true;
		return false;
	}
}
