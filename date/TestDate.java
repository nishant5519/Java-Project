package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.zone.ZoneRules;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		// System.out.println(ZoneId.systemDefault());
		// TimeZone.getAvailableIDs();
		System.out.println(TimeZone.getAvailableIDs());
		Calendar cal = Calendar.getInstance();
		TimeZone tz = TimeZone.getTimeZone("CST");
		cal.setTimeZone(tz);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:m a");
		java.util.Date parsedDate = null;
		parsedDate = dateFormat.parse("03/12/2021 06:00 AM");
		cal.setTime(parsedDate);
		String dateComp = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR);
		String timeComp = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":"
				+ cal.get(Calendar.SECOND) + ":" + cal.get(Calendar.MILLISECOND);

		// cal.set(Calendar.ZONE_OFFSET, cal.get( Calendar.ZONE_OFFSET));
		System.out.println(dateComp + " " + timeComp);

		System.out.println(cal.getTimeInMillis());
		System.out.println(cal.getTime());

		System.out.println("==============");
		Calendar calendar = Calendar.getInstance(Locale.getDefault());
		TimeZone timezone = TimeZone.getTimeZone("CST");
		calendar.setTimeZone(timezone);
		float serverZoneOffsetInHours = (calendar.get(Calendar.ZONE_OFFSET) +
				+ calendar.get(Calendar.DST_OFFSET)) / (60 * 60* 1000);
		float serverZoneOffsetInHours2 = calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000);
		float serverZoneOffsetInHours3 = calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000);

		System.out.println(serverZoneOffsetInHours);
		System.out.println(serverZoneOffsetInHours2);
		System.out.println(serverZoneOffsetInHours3);

		System.out.println(getCurrentTimezoneOffset());
		System.out.println(getOffset(TimeZone.getTimeZone("CST")));
	}

	public static float getCurrentTimezoneOffset() {

		//TimeZone tz = TimeZone.getDefault();
		 TimeZone tz = TimeZone.getTimeZone("CST");
		/*
		 * String[] timezones = TimeZone.getAvailableIDs(); for(String str : timezones)
		 * System.out.print(str + ",");
		 */
		Calendar calendar = GregorianCalendar.getInstance(tz);
		calendar.setTimeZone(tz);

		int offsetInMillis = tz.getOffset(calendar.getTimeInMillis());

		String offset = String.format("%01d.%02d", Math.abs(offsetInMillis / 3600000),
				Math.abs((offsetInMillis / 60000) % 60));
		System.out.println("offset :" + offset);
		float f = Float.parseFloat(offset);
		// f = (offsetInMillis >= 0 ? "+" : "-") + f;

		return (offsetInMillis >= 0 ? f : -1*f);
	}

	public static ZoneOffset getOffset(TimeZone timeZone) { //for using ZoneOffsett class
	    ZoneId zi = timeZone.toZoneId();
	    ZoneRules zr = zi.getRules();
	    return zr.getOffset(LocalDateTime.now());
	}

	public static long getOffsetHours(TimeZone timeZone) { //just hour offset
	    ZoneOffset zo = getOffset(timeZone);
	   return TimeUnit.SECONDS.toHours(zo.getTotalSeconds());
	}
}
