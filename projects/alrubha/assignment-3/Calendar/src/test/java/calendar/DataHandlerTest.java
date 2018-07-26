
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
import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.lang.reflect.*;



public class DataHandlerTest{

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() {
      File testfile = new File("calendar_test.xml");
      testfile.delete();
      testfile = new File("calendar.xml");
      testfile.delete();
  }

  @After
  public void tearDown() {
      File testfile = new File("calendar_test.xml");
      testfile.delete();
      testfile = new File("calendar.xml");
      testfile.delete();
  }

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
	    assertFalse(data.saveAppt(appt0));
	 	assertFalse(data.saveAppt(appt1));
	  	assertFalse(data.saveAppt(appt2));
	    assertFalse(data.saveAppt(appt3));

	  LinkedList<CalDay> calDays = new LinkedList<CalDay>();
 	  calDays = (LinkedList<CalDay>) data.getApptRange(one,two);	

	  
  }
  
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {

	DataHandler data = new DataHandler("calendar_test.xml",false);
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
	
  }
  
  
    @Test(timeout = 4000)
  public void test05()  throws Throwable  {

  	DataHandler dataHandler = new DataHandler();
	Appt appt0 = new Appt(7,7,17,7,-2018,"appointment","Dentist", "xyz@gmail.com");	//invalid year
	appt0.setValid();
	assertFalse(dataHandler.saveAppt(appt0));
	assertFalse(dataHandler.deleteAppt(appt0));

  }

  @Test(expected = DateOutOfRangeException.class)
    public void test06()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 7, 20);
        GregorianCalendar second = new GregorianCalendar(2018, 7, 25);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(second, first);
    }
	
	@Test(timeout = 4000)
  public void test07()  throws Throwable  {
      GregorianCalendar day = new GregorianCalendar(2018, 7, 10);
      CalDay day0 = new CalDay(day);
      Appt appt0 = new Appt(-100, 5, 7, 6, 2018, "birthday", "This is a party", "xyz@gmail.com");
      appt0.setValid();
      day0.addAppt(appt0);
      DataHandler data0 = new DataHandler("calendar_test.xml");
      assertFalse(data0.saveAppt(appt0));
  }
  
  	@Test(timeout = 4000)
    public void test08()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml");
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "meeting", "This is a meeting", "xyz@gmail.com");
        appt0.setValid();
        data0.saveAppt(appt0);
        data0.deleteAppt(appt0);
        assertNull(appt0.getXmlElement());
    }
	
	@Test(timeout = 4000)
    public void test09()  throws Throwable  {
        GregorianCalendar day = new GregorianCalendar(2018, 5, 10);
        CalDay day0 = new CalDay(day);
        Appt appt0 = new Appt(8, 5, 7, 6, 2018, "meeting", "This is a meeting", "xyz@gmail.com");
        day0.addAppt(appt0);
        DataHandler data0 = new DataHandler("calendar_test.xml", false);
        assertFalse(data0.deleteAppt(appt0));
    }

	@Test(timeout = 4000)
    public void test10()  throws Throwable  {
        GregorianCalendar day = new GregorianCalendar(2018, 5, 10);
        CalDay day0 = new CalDay(day);
        Appt appt0 = new Appt(8, 5, 7, 6, 2018, "meeting", "This is a meeting", "xyz@gmail.com");
        day0.addAppt(appt0);
        DataHandler data0 = new DataHandler("calendar_test.xml", false);
        data0.saveAppt(appt0);
        assertTrue(data0.deleteAppt(appt0));
    }
	
	 @Test(timeout = 4000)
    public void test11()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml", false);
        GregorianCalendar firstday = new GregorianCalendar(2018, 0, 1);
        GregorianCalendar lastday = new GregorianCalendar(2018, 1, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "party", "birthday", "xyz@gmail.com");
        appt0.setValid();
        data0.saveAppt(appt0);
        data0.deleteAppt(appt0);
        File testfile = new File("calendar_test.xml");
        assertFalse(testfile.delete());
    }

    @Test(timeout = 4000)
    public void test12()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar firstday = new GregorianCalendar(2018, 0, 1);
        GregorianCalendar lastday = new GregorianCalendar(2018, 1, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "party", "birthday", "xyz@gmail.com");
        appt0.setValid();
        data0.saveAppt(appt0);
        data0.deleteAppt(appt0);
        File testfile = new File("calendar_test.xml");
        assertTrue(testfile.delete());
    }

	@Test(timeout = 4000)
    public void test13()  throws Throwable  {
        System.setOut(new PrintStream(outContent));
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 7, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 8, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "party", "birthday", "xyz@gmail.com");
        int[] recurDaysArr = {1};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, 1);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);
        assertEquals("", outContent.toString());
    }
	
  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
	  
	    DataHandler data0 = new DataHandler();
        GregorianCalendar first = new GregorianCalendar(2018, 0, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 1, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "party", "birthday", "xyz@gmail.com");
        int[] recurDaysArr = {7};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, 10);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);
		
		int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
		
        assertEquals(5, num);
		
  }
  
  
    @Test(timeout = 4000)
    public void test15()  throws Throwable  {
        DataHandler data0 = new DataHandler();
        GregorianCalendar first = new GregorianCalendar(2018, 7, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 8, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "party", "birthday", "xyz@gmail.com");
        int[] recurDaysArr = {};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);

		int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
        assertEquals(4, num);
    }
	
	
	
	 @Test(timeout = 4000)
    public void test16()  throws Throwable  {
        DataHandler data0 = new DataHandler();
        GregorianCalendar first = new GregorianCalendar(2018, 7, 1);
        GregorianCalendar second = new GregorianCalendar(2050, 10, 20);
        Appt appt0 = new Appt(8, 10, 1, 5, 2000, "party", "birthday", "xyz@gmail.com");
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);
        
		int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
	
        assertEquals(0, num);
	}
	
	
	
	@Test(timeout = 4000)
    public void test17()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar firstday = new GregorianCalendar(2018, 1, 1);
        GregorianCalendar lastday = new GregorianCalendar(2050, 10, 20);
        Appt appt0 = new Appt(8, 10, 1, 5, 2000, "Meeting", "This is a meeting", "work@gmail.com");
        int[] recurDaysArr = {2,3,4};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(firstday, lastday);
		
		int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
		
        assertEquals(33, num);
    }
		
	@Test(timeout = 4000)
    public void test18()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 0, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 1, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "Event", "This is an event", "xyz@gmail.com");
        int[] recurDaysArr = {6};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, 10);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);

	int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
	
        assertEquals(5, num);	
    
	}
	
	@Test(timeout = 4000)
    public void test19()  throws Throwable  {
		
		DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 6, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 7, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "Event", "This is an event", "xyz@gmail.com");
        int[] recurDaysArr = {1};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, 1);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);

	int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
	
        assertEquals(0, num);	
		
	}
	
	 @Test(timeout = 4000)
    public void test20()  throws Throwable  {
        System.setOut(new PrintStream(outContent));
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 0, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 1, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "Event", "This is an event.", "home@yahoo.com");
        int[] recurDaysArr = {1};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, 1);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);
        assertEquals("", outContent.toString());
    }
		
	 @Test(timeout = 4000)
    public void test21()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 1, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 10, 20);
        Appt appt0 = new Appt(8, 10, 1, 5, 2050, "party", "birthday", "xyz@gmail.com");
        int[] recurDaysArr = {2,3,4};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);
        int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
        assertEquals(0, num);
    }
	
	@Test(timeout = 4000)
    public void test22()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 0, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 1, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "party", "birthday", "xyz@gmail.com");
        int[] recurDaysArr = {1};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, 1);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);
        int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
        assertEquals(2, num);
    }

	@Test(timeout = 4000)
    public void test23()  throws Throwable  {
		
		DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 1, 1);
        GregorianCalendar second = new GregorianCalendar(2019, 10, 20);
        Appt appt0 = new Appt(8, 10, 1, 5, 2000, "party", "birthday", "xyz@gmail.com");
        int[] recurDaysArr = {1, 2, 3, 4, 5};
        appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);
        int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
        assertEquals(22, num);
	}
	
	    @Test(timeout = 4000)
    public void test24()  throws Throwable  {
        DataHandler data0 = new DataHandler("calendar_test.xml");
        GregorianCalendar first = new GregorianCalendar(2018, 0, 1);
        GregorianCalendar second = new GregorianCalendar(2018, 1, 1);
        Appt appt0 = new Appt(5, 5, 1, 1, 2018, "Event", "This is an event.", "home@yahoo.com");
        int[] recurDaysArr = {8};
        appt0.setRecurrence(recurDaysArr, -404, 1, 100);
        appt0.setValid();
        data0.saveAppt(appt0);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = (LinkedList<CalDay>) data0.getApptRange(first, second);
        int num = 0;
        for (int i = 0; i < calDays.size(); i++) {
            LinkedList<Appt>  appts = calDays.get(i).getAppts();
            for(int j = 0; j < appts.size(); j++) {
                num++;
            }
        }
        assertEquals(1, num);
    }
	
}
