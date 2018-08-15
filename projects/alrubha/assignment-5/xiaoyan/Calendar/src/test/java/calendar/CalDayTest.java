/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;
import calendar.DataHandler;
import java.util.LinkedList;



public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  
	  CalDay calday = new CalDay();
	  assertFalse(calday.isValid());
	  assertNull(calday.iterator());

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

	  GregorianCalendar cal = new GregorianCalendar(2018,10,20);
	  CalDay calday = new CalDay(cal);
	  assertEquals(2018, calday.year);
	  assertEquals(10,calday.month);
	  assertEquals(20,calday.day);
	  assertEquals(20,calday.getDay());
	  assertEquals(10,calday.getMonth());
	  assertEquals(2018,calday.getYear());


  }
  
    @Test(timeout = 4000)
  public void test02()  throws Throwable  {
	  
	  GregorianCalendar cal = new GregorianCalendar(2018,10,20);
	  Appt appt0 = new Appt(10, 10, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  Appt appt1 = new Appt(15, 12, 10, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  CalDay calday = new CalDay(cal);
	  calday.addAppt(appt0);
	  calday.addAppt(appt1);
	  assertEquals(2,calday.getSizeAppts());

  }

    @Test(timeout = 4000)
  public void test03()  throws Throwable  {

	  GregorianCalendar cal = new GregorianCalendar(2018,10,20);
	  CalDay calday = new CalDay(cal);
	  assertNotNull(calday.toString());
	
  }
  
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      GregorianCalendar cal = new GregorianCalendar(2018, 7, 16);
      CalDay calday = new CalDay(cal);
      Appt appt0 = new Appt(7, 16, 2018, "party", "party all day", "xyz@gmail@gmail.com");
      Appt appt1 = new Appt(0, 5, 7, 16, 2018, "birthday", "my party", "xyz@gmail@gmail@gmail.com");
      Appt appt2 = new Appt(20, 10, 7, 16, 2018, "party", "night", "xyz@gmail.com");
	  Appt appt3 = new Appt(12, 5, 7, 6, 2018, "Meeting", "This is a meeting", "xyz@gmail.com");
      calday.addAppt(appt0);
      calday.addAppt(appt1);
      calday.addAppt(appt2);
	  calday.addAppt(appt3);
      String test = calday.getFullInfomrationApp(calday);
	  assertNotNull(calday.getFullInfomrationApp(calday));
	  assertEquals("7-16-2018 \n\tparty party all day \n\t12:05AM birthday my party \n\t0:05AM Meeting This is a meeting \n\t8:10PM party night ",test);

  }

  
   @Test(timeout = 4000)
  public void test05()  throws Throwable  {

	  CalDay cal = new CalDay();
      String test = cal.toString();
	  assertNotNull(cal.toString());

  }
  
     @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	  
    GregorianCalendar cal = new GregorianCalendar(2018, 7, 16);
	CalDay calday = new CalDay(cal);
	Appt appt0 = new Appt(-7,7,17,7,2018,"appointment","Dentist", "xyz@gmail.com");	//invalid appt
	appt0.setValid();
	calday.addAppt(appt0);
	assertNotNull(calday.toString());

  }
  
   @Test(timeout = 4000)
  public void test07()  throws Throwable  {

    GregorianCalendar cal = new GregorianCalendar(2018, 7, 16);
	CalDay calday = new CalDay(cal);
	Appt appt0 = new Appt(7,7,17,7,2018,"appointment","Dentist", "xyz@gmail.com");	//valid appt
	appt0.setValid();
	calday.addAppt(appt0);
	assertNotNull(calday.toString());
  }
  
   @Test(timeout = 4000)
  public void test08()  throws Throwable  {
	  
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 1);
	CalDay calday = new CalDay(cal);
	Appt appt0 = new Appt(23,59,1,12,2018,"Birthday Party", "This is my birthday party", "xyz@gmail.com");
	appt0.setValid();
	calday.addAppt(appt0);

  }
  
//******

@Test(timeout = 4000)
  public void test09()  throws Throwable  {
      GregorianCalendar day = new GregorianCalendar(2018, 5, 10);
      CalDay cal = new CalDay(day);
      Appt appt0 = new Appt(8, 5, 7, 6, 2018, "Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt1 = new Appt(10, 5, 7, 6, 2018, "Meeting", "This is a meeting", "zyz@gmail.com");
      cal.addAppt(appt0);
      cal.addAppt(appt1);
      String string0 = cal.toString();
      assertEquals("\t --- 6/10/2018 --- \n --- -------- Appointments ------------ --- \n" +
	  "\t6/7/2018 at 8:5am ,Party, This is my birthday party\n" +
	  " \t6/7/2018 at 10:5am ,Meeting, This is a meeting\n \n", string0);
	  //assertNotNull(string0);
  }
  
    @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      GregorianCalendar day = new GregorianCalendar(2018, 5, 10);
      CalDay cal = new CalDay(day);
      Appt appt0 = new Appt(10, 5, 7, 6, 2018, "Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt1 = new Appt(8, 5, 7, 6, 2018, "Meeting", "This is a meeting", "xyz@gmail.com");
      Appt appt2 = new Appt(14, 5, 7, 6, 2018, "Test", "Test", "xyz@gmail.com");
      Appt appt3 = new Appt(14, 5, 7, 6, 2018, "Test2", "Test", "xyz@gmail.com");
      cal.addAppt(appt0);
      cal.addAppt(appt1);
      cal.addAppt(appt2);
      cal.addAppt(appt3);
      String string0 = cal.toString();
      assertEquals("\t --- 6/10/2018 --- \n --- -------- Appointments ------------ --- \n" +
	  "\t6/7/2018 at 8:5am ,Meeting, This is a meeting\n" +
	  " \t6/7/2018 at 10:5am ,Party, This is my birthday party\n" +
	  " \t6/7/2018 at 2:5pm ,Test, Test\n" +
	  " \t6/7/2018 at 2:5pm ,Test2, Test\n" +
	   " \n", string0);
	  //assertNotNull(string0);
  }
  
}

//hr,min,dy,mn,yr,ttl,des,em
