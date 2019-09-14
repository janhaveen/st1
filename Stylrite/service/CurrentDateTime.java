package org.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime {
	
	public static String CurrentTime()
	{
		LocalDateTime dateStart = LocalDateTime.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	     String formatDateTime = dateStart.format(formatter);
		return formatDateTime;
	}
	
	public static Timestamp CurrentTimestamp()
	{
		long time = System.currentTimeMillis();
		
		Timestamp timestamp = new Timestamp(time);
		
		return timestamp;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(CurrentTime());
	}
}
