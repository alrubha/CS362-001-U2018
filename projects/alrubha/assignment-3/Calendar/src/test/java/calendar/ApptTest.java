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
      //assertTrue(!appt0.getValid());
      assertFalse(appt0.getValid());
	  //
      
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
	 
	Appt appt1 = new Appt(12, 11, 15, 9,2019,"appointment","dentist","xyz@gmail.com");
	appt1.setValid();
	int[] recurDaysArr={2,3,4};
    appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
    appt1.setValid();
	//assertEquals(2, appt1.getRecurBy());
	assertEquals(1, appt1.getRecurBy());
	//
	assertTrue(appt1.isRecurring());
    assertEquals(2, appt1.getRecurIncrement());
	assertEquals("appointment",appt1.getTitle());
	assertEquals(recurDaysArr, appt1.getRecurDays());
	assertTrue(appt1.getValid());
	//assertFalse(appt1.getValid());	
	assertFalse(appt1.isOn(5,8,2022));	//everything invalid


}

@Test(timeout = 4000)
 public void test02()  throws Throwable  {
	 
	 Appt appt2 = new Appt(25,13,2019,null,null,null);
	 appt2.setValid();
	 //assertEquals(-1,appt2.getStartHour());
	 assertEquals(-1,appt2.getStartHour());
	 //
	 assertEquals(-1,appt2.getStartMinute());
	 assertEquals(25,appt2.getStartDay());
	 assertEquals(13,appt2.getStartMonth());
	 assertEquals(2019,appt2.getStartYear());
	 //assertEquals(null,appt2.getDescription());
	 assertEquals("",appt2.getDescription());
	 //assertEquals(null,appt2.getEmailAddress());
	 assertEquals("",appt2.getEmailAddress());
	 assertFalse(appt2.hasTimeSet());
	 //assertTrue(appt2.hasTimeSet());

	 
	 	 
}	 

@Test(timeout = 4000)
 public void test03()  throws Throwable  {
	 
	  Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  int[] recurDaysArr=null;
	  appt0.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
      appt0.setValid();
	  assertTrue(appt0.isOn(9,14,2018));	//valid
	  assertTrue(appt0.hasTimeSet());
	 
	 	 
}	 

@Test(timeout = 4000)
 public void test04()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,7,17,7,2018,"appointment","Dentist", "xyz@gmail.com");
	appt0.setValid();
	assertTrue(appt0.isOn(17,7,2018));	//valid
		 	 
}	 


@Test(timeout = 4000)
 public void test05()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,7,17,7,2018,"appointment","Dentist", "xyz@gmail.com");
	appt0.setValid();
	assertFalse(appt0.isOn(18,7,2018));	//day invalid
		 	 
	 	 
}	 


@Test(timeout = 4000)
 public void test06()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,7,17,7,2018,"appointment","Dentist", "xyz@gmail.com");
	appt0.setValid();
	assertFalse(appt0.isOn(17,8,2018));	//month invalid
		 	 
	 	 
}	 


@Test(timeout = 4000)
 public void test07()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,7,17,7,2018,"appointment","Dentist", "xyz@gmail.com");
	appt0.setValid();
	assertFalse(appt0.isOn(17,7,2019));	//year invalid
		 	 
	 	 
}	 


@Test(timeout = 4000)
 public void test08()  throws Throwable  {
	 
	Appt appt0 = new Appt(-7,7,17,7,2018,"appointment","Dentist", "xyz@gmail.com"); //hours is too low
	appt0.setValid();
	assertFalse(appt0.getValid());	 	 
	 //assertTrue(appt0.getValid());		 
}	 


@Test(timeout = 4000)
 public void test09()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,-7,17,7,2018,"appointment","Dentist", "xyz@gmail.com"); //minutes is too low
	appt0.setValid();
	assertFalse(appt0.getValid());	 	 
	 // assertTrue(appt0.getValid());	 	 

	 	 
}	 


@Test(timeout = 4000)
 public void test10()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,7,-17,7,2018,"appointment","Dentist", "xyz@gmail.com");	//invalid day
	appt0.setValid();
	assertFalse(appt0.getValid());	
	  //assertTrue(appt0.getValid());	 	 
	
	 	 
}	 


@Test(timeout = 4000)
 public void test11()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,7,17,-7,2018,"appointment","Dentist", "xyz@gmail.com");	//invalid month
	appt0.setValid();
	assertFalse(appt0.getValid());
	 // assertTrue(appt0.getValid());	 	 
	
	 	 
}	 


@Test(timeout = 4000)
 public void test12()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,7,17,7,-2018,"appointment","Dentist", "xyz@gmail.com");	//invalid year
	appt0.setValid();
	assertFalse(appt0.getValid());
	  //assertTrue(appt0.getValid());	 	 
	
	
}	 


@Test(timeout = 4000)
 public void test13()  throws Throwable  {
	 
	Appt appt0 = new Appt(24,7,17,7,2018,"appointment","Dentist", "xyz@gmail.com");	//hours is too high
	appt0.setValid();
	assertFalse(appt0.getValid());	 
    //assertTrue(appt0.getValid());		
	 	 
}	 


@Test(timeout = 4000)
 public void test14()  throws Throwable  {
	 
	Appt appt0 = new Appt(7,61,17,7,2018,"appointment","Dentist", "xyz@gmail.com");	//minute is too high
	appt0.setValid();
	assertFalse(appt0.getValid());
	 // assertTrue(appt0.getValid());	 	 
	
	 	 
}	 

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Appt appt0 = new Appt(7, 7, 17, 7, 2018, "appointment", "dentist", "xyz@gmail@gmail.com");
      appt0.setValid();
      String test = appt0.toString();
      assertTrue(appt0.getValid());
	  	//assertFalse(appt0.getValid());	 	 

  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Appt appt0 = new Appt(-7, -7, -17, -7, -2018, "appointment", "dentist", "xyz@gmail@gmail.com");
      appt0.setValid();
      String test = appt0.toString();
      assertFalse(appt0.getValid());
	    //assertTrue(appt0.getValid());	 	 

  }
//*************************************************************************************************
  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Appt appt0 = new Appt(0, 5, 5, 5, 100, "Test", "This is test", "xyz@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
  }
  
  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Appt appt0 = new Appt(0, 5, 5, 5, 100, "Test", "This is a test", "xyz@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
  }
  
  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Appt appt0 = new Appt(24, 5, 5, 5, 5, "Test", "This is a test", "xyz@gmail.com");
      appt0.setValid();
      //assertTrue(appt0.getValid());
	    assertFalse(appt0.getValid());

  }

    @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Appt appt0 = new Appt(-1, 5, 5, 5, 100, "Test", "This is a test", "xyz@gmail.com");
      appt0.setValid();
      //assertTrue(appt0.getValid());
	  assertFalse(appt0.getValid());
  }

    @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Appt appt0 = new Appt(12, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertNotNull(string0);
  }
  
    @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Appt appt0 = new Appt(3,3,7,1,2018,"Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  appt0.setValid();
	  assertTrue(appt0.getValid());
  }
  
      @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Appt appt0 = new Appt(1,0,24,12,2018,"Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  appt0.setValid();
	  assertTrue(appt0.getValid());
  }
  
      @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Appt appt0 = new Appt(23,59,24,12,2018,"Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  appt0.setValid();
	  assertTrue(appt0.getValid());
  }
  
       @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Appt appt0 = new Appt(23,59,24,12,0,"Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  appt0.setValid();
	  assertFalse(appt0.getValid());
  }
  
        @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Appt appt0 = new Appt(23,59,1,12,2018,"Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  appt0.setValid();
	  assertTrue(appt0.getValid());
  }
  
        @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Appt appt0 = new Appt(5,5,30,5,5,"Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  appt0.setValid();
	  assertTrue(appt0.getValid());
  }
  
  //****
  
    @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Appt appt0 = new Appt(5, 5, CalendarUtil.NumDaysInMonth(5, 5-1), 5, 5, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
  }
  
  //****
  
    @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Appt appt0 = new Appt(10, 15, 2019, "Test", "This is a test", "xyz@gmail.com");
      //assertTrue(appt0.hasTimeSet());
	    assertFalse(appt0.hasTimeSet());

  }
  
    @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Appt appt0 = new Appt(5,5,30,5,5,"Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  appt0.setXmlElement(null);
      assertTrue(appt0.hasTimeSet());
	  
  }
  
  @Test(timeout = 4000)
 public void test31()  throws Throwable  {
	 
	Appt appt0 = new Appt(24,23,17,7,2018,"appointment","Dentist", "xyz@gmail.com");	//hours is too high
	appt0.setValid();
	assertFalse(appt0.getValid());	 
    //assertTrue(appt0.getValid());		 	 
  }	 

  //***
  
  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Appt appt0 = new Appt(15, 15, 12, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Appt appt0 = new Appt(12, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertNotNull(string0);
  }
  
  //***
 @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 12, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals("\t14/12/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
  }
  
  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Appt appt0 = new Appt(12, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals("\t14/12/2018 at -1:-1am ,Birthday Party, This is my birthday party\n", string0);
  }
 
}//class

//hr,min,dy,mn,yr,ttl,des,em