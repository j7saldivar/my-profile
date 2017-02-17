package com.saldivar.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilities that might be used at all package levels
 * 
 * @author Jorge.Saldivar
 *
 */
public class ProjectUtilities {
	
	private ProjectUtilities() {}

	/**
	 * 
	 * @return date in a {@link String} format
	 */
	public static String dateTimeNow() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH_mm_ss");
		Date date = new Date();
		return sdf.format(date);

	}

}
