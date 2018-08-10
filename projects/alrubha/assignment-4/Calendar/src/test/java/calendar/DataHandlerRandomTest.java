package calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.io.*;
import java.lang.reflect.*;

import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;
import java.util.Calendar;
import java.util.*;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

	private static final long TestTimeout = 20 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	//clean up file before test
	     @Before
	     public void setUp() {
	         File testfile = new File("calendar_test.xml");
	         testfile.delete();
	     }

	     //clean up file after test
	     @After
	     public void tearDown() {
	         File testfile = new File("calendar_test.xml");
	         testfile.delete();
	     }

    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed = System.currentTimeMillis(); //10
				 Random random = new Random(randomseed);

				 boolean autoSave = ValuesGenerator.getBoolean(.50f, random);

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

				 int startHour3=ValuesGenerator.getRandomIntBetween(random, -1, 24);
				 int startMinute3=ValuesGenerator.getRandomIntBetween(random, -1, 60);
	 			 int startDay3=ValuesGenerator.getRandomIntBetween(random, 0, 32);
	  		 int startMonth3=ValuesGenerator.getRandomIntBetween(random, 0, 13);
				 int startYear3=ValuesGenerator.getRandomIntBetween(random, 2018, 2020);
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
						Appt appt3 = new Appt(startHour3,
											startMinute3 ,
											startDay3 ,
											startMonth3 ,
											startYear3 ,
											title,
											description,
											emailAddress);
					 appt3.setXmlElement(null);
					 appt.setValid();
					 appt2.setValid();
					 appt3.setValid();

					 DataHandler data = new DataHandler("calendar_test.xml", autoSave);

					 //random start
					 int firstDay=ValuesGenerator.getRandomIntBetween(random, 0, 32);
					 int firstMonth=ValuesGenerator.getRandomIntBetween(random, 0, 13);
					 int firstYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2019);

					 //random end
					 int lastDay=ValuesGenerator.getRandomIntBetween(random, 0, 32);
					 int lastMonth=ValuesGenerator.getRandomIntBetween(random, 0, 13);
					 int lastYear=ValuesGenerator.getRandomIntBetween(random, 2020, 2021);


					GregorianCalendar firstday = new GregorianCalendar(firstYear, firstMonth, firstDay);
					GregorianCalendar lastday = new GregorianCalendar(lastYear, lastMonth, lastDay);

					LinkedList<CalDay> calDays = new LinkedList<CalDay>();
					calDays = (LinkedList<CalDay>) data.getApptRange(firstday, lastday);

					 data.saveAppt(appt);
					 data.saveAppt(appt2);
					 data.saveAppt(appt3);

					 data.deleteAppt(appt);
					 data.deleteAppt(appt2);
					 data.deleteAppt(appt3);

/*
					 //delete one out of every ten appointments
 					if(ValuesGenerator.getBoolean(.10f, random)) {
 						data0.deleteAppt(appt0);
 					}
*/
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
