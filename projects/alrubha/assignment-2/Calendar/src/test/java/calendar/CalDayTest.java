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

	  GregorianCalendar cal = new GregorianCalendar(2018,10,20);
	  Appt appt0 = new Appt(13, 7, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  Appt appt1 = new Appt(14, 9, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  CalDay calday = new CalDay(cal);
	  calday.addAppt(appt0);
	  calday.addAppt(appt1);
	  assertNotNull(calday.getFullInfomrationApp(calday));

  }
  
   @Test(timeout = 4000)
  public void test05()  throws Throwable  {

	  CalDay cal = new CalDay();
      String string0 = cal.toString();
      String string1 = "\t --- 7/10/2018 --- \n --- -------- Appointments ------------ --- \n\n";
      assertFalse(string0.equals(string1));

  }
  
}
