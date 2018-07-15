
/** A JUnit test class to test the class DataHandler. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;
import calendar.CalendarUtil;


import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  
	  DataHandler data = new DataHandler();
	  Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  assertTrue(data.saveAppt(appt0));
	  assertTrue(data.save());
	  assertTrue(data.deleteAppt(appt0));
  }
  
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

	  DataHandler data = new DataHandler();
	  GregorianCalendar one = new GregorianCalendar(2018,7,1);
 	  GregorianCalendar two = new GregorianCalendar(2018,7,28);
	  Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday", "This is my birthday party", "xyz@gmail.com");  
      appt0.setValid();
	  Appt appt1 = new Appt(14, 30, 9, 14, 2018, "Party", "This is my birthday party", "xyz@gmail.com");
	  int[] recurDaysArr={2,3,4};
	  appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
      appt1.setValid();
      Appt appt2 = new Appt(13, 30, 9, 14, 2018, "hello", "This is my birthday party", "xyz@gmail.com");  
      appt2.setValid();
	  Appt appt3 = new Appt(12, 30, 9, 14, 2018, "world", "This is my birthday party", "xyz@gmail.com");
      appt3.setValid();  
	  assertTrue(data.saveAppt(appt0));
	  assertTrue(data.saveAppt(appt1));
	  assertTrue(data.saveAppt(appt2));
	  assertTrue(data.saveAppt(appt3));
	  LinkedList<CalDay> calDays = new LinkedList<CalDay>();
 	  calDays = (LinkedList<CalDay>) data.getApptRange(one,two);	

	  
  }
  
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {

	DataHandler data = new DataHandler("calendar2.xml",false);
	Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday", "This is my birthday party", "xyz@gmail.com");  
	assertTrue(data.saveAppt(appt0));

  }
  
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {

	  GregorianCalendar someday = new GregorianCalendar(2018,7,10);
      CalDay cal = new CalDay(someday);
      Appt appt0 = new Appt(8, 5, 7, 6, 2018, "class", "classroom", "123@gmail.com");
      cal.addAppt(appt0);
      DataHandler data0 = new DataHandler("calendar_test.xml");
      assertTrue(data0.saveAppt(appt0));	

  }
  
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {

  	DataHandler data1 = new DataHandler("cal",false);
	Appt appt0 = null;
	assertTrue(data1.saveAppt(appt0));
	assertTrue(data1.deleteAppt(appt0));
	
  }

}
