import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;


public class DateTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate d = LocalDate.now(); // only will give you the date (eariler versions also gave time)
		LocalDate d2 = LocalDate.of(1989, 8, 20);
		LocalDate d3 = LocalDate.of(1989, Month.AUGUST, 20);
		System.out.println(d);
		System.out.println(d2);
		System.out.println(d3);
		
		LocalTime t = LocalTime.now(); // only will give you the date (eariler versions also gave time)
		LocalTime t2 = LocalTime.of(12, 59, 20, 100);

		System.out.println(t);
		System.out.println(t2);
		
		LocalTime tz = LocalTime.now(ZoneId.of("Canada/Saskatchewan"));
		System.out.println(tz);
		//machine readable time
		Instant i = Instant.now();
		System.out.println(i);
//		for (String s: ZoneId.getAvailableZoneIds()){
//			System.out.println(s);
//		}

	}
	}


