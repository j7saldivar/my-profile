package com.saldivar.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectUtilities {
	
	private ProjectUtilities() {}

	public static String dateTimeNow() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH_mm_ss");
		Date date = new Date();
		return sdf.format(date);

	}

}
