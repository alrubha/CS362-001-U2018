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
      calday.addAppt(appt0);
      calday.addAppt(appt1);
      calday.addAppt(appt2);
      String test = calday.getFullInfomrationApp(calday);
	  assertNotNull(calday.getFullInfomrationApp(calday));

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


	 
  }
  
  @Test(timeout = 4000)
  public void test09()  throws Throwable  {

	 
  }
  
}
