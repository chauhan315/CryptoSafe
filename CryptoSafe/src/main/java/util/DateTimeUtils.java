package util;

import java.time.LocalDateTime;

public class DateTimeUtils {
	LocalDateTime dt = LocalDateTime.now();
	
	public static void main(String[] args) {
		System.out.println(new DateTimeUtils().dt);
	}
}
