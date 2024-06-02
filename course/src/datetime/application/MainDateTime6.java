package datetime.application;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class MainDateTime6 {

	public static void main(String[] args) {
		
		//Somando uma unidade de tempo
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println(sdf.format(d));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4);
		d = cal.getTime();
		
		System.out.println(sdf.format(d));

		//Obtendo uma unidade de tempo
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date d1 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println(sdf1.format(d1));
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(d1);
		int minutes = cal1.get(Calendar.MINUTE);
		int month = 1 + cal1.get(Calendar.MONTH);
		
		System.out.println("Minutes: " + minutes);
		System.out.println("Month: " + month);

	}

}
