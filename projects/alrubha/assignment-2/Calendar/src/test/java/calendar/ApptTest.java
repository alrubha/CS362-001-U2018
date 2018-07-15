/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt0.setValid();
	  appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals(0, appt0.getRecurIncrement());
      assertEquals("Birthday Party",appt0.getTitle());
	  assertEquals(30,appt0.getStartMinute());//
	  assertEquals(9,appt0.getStartDay());
	  assertEquals(14,appt0.getStartMonth());
	  assertEquals(2018,appt0.getStartYear());
	  assertEquals("This is my birthday party",appt0.getDescription());
	  assertEquals("xyz@gmail.com",appt0.getEmailAddress());//
      assertTrue(!appt0.getValid());
      
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
	 
	Appt appt1 = new Appt(12, 11, 15, 9,2019,"appointment","dentist","xyz@gmail.com");
	appt1.setValid();
	int[] recurDaysArr={2,3,4};
    appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
    appt1.setValid();
	assertEquals(2, appt1.getRecurBy());
	assertTrue(appt1.isRecurring());
    assertEquals(2, appt1.getRecurIncrement());
	assertEquals("appointment",appt1.getTitle());
	assertEquals(recurDaysArr, appt1.getRecurDays());
	assertTrue(!appt1.getValid());
	assertFalse(appt1.isOn(5,8,2022));


}

@Test(timeout = 4000)
 public void test02()  throws Throwable  {
	 
	 Appt appt2 = new Appt(25,13,2019,null,null,null);
	 appt2.setValid();
	 assertEquals(-1,appt2.getStartHour());
	 assertEquals(-1,appt2.getStartMinute());
	 assertEquals(25,appt2.getStartDay());
	 assertEquals(13,appt2.getStartMonth());
	 assertEquals(2019,appt2.getStartYear());
	 assertEquals(null,appt2.getDescription());
	 assertEquals(null,appt2.getEmailAddress());
	 assertFalse(appt2.hasTimeSet());
	 
	 	 
}	 

@Test(timeout = 4000)
 public void test03()  throws Throwable  {
	 
	  Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  int[] recurDaysArr=null;
	  appt0.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
      appt0.setValid();
	  assertTrue(appt0.isOn(9,14,2018));
	  assertTrue(appt0.hasTimeSet());
	 
	 	 
}	 


}//class

