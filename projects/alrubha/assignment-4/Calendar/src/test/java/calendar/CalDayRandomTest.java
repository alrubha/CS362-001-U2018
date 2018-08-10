package calendar;

import calendar.Appt;
import calendar.CalDay;
import java.util.*;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	/**
	 * Generate Random Tests that tests CalDay Class.
	 */

	private static final long TestTimeout = 20 * 500 * 1;

	@Test
	  public void randomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
 		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

 		 System.out.println("Start testing...");

 		try{
 			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				String title="Birthday Party";
				String description="This is my birthday party.";
				String emailAddress="xyz@gmail.com";

				/* This is for another appt object for set valid test*/
				int startHour2=ValuesGenerator.getRandomIntBetween(random, -1, 24);
				int startMinute2=ValuesGenerator.getRandomIntBetween(random, -1, 60);
				int startDay2=ValuesGenerator.getRandomIntBetween(random, -1, 35);
				int startMonth2=ValuesGenerator.getRandomIntBetween(random, 0, 13);
				int startYear2=ValuesGenerator.getRandomIntBetween(random, -1, 2018);

				//Construct a new Appointment object with the initial data
						Appt appt = new Appt(startHour,
										 startMinute ,
										 startDay ,
										 startMonth ,
										 startYear ,
										 title,
										description,
										emailAddress);
					 Appt appt2 = new Appt(startHour2,
										 startMinute2 ,
										 startDay2 ,
										 startMonth2 ,
										 startYear2 ,
										 title,
										 description,
										 emailAddress);

		  		GregorianCalendar day = new GregorianCalendar(startYear, startMonth, startDay);
	      	CalDay calday = new CalDay(day);

		  		appt.setValid();
		  		appt2.setValid();
		  		calday.addAppt(appt);
	      	calday.addAppt(appt2);

				//show elapsed time
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			   	if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}

		}catch(NullPointerException e){
		}

		System.out.println("Done testing...");
 	}
}
