package de.bierwuerfel.test;


import org.junit.Before;

import de.bierwuerfel.User;
import de.bierwuerfel.Bier;
import junit.framework.*;

public class UserTest extends TestCase
{
	User user;
	
	public void setUp() throws Exception 
	{
		user = new User();
	}

	public void testWuerfel()
	{
		try {
			assertEquals(user.wuerfeln().getClass() == de.bierwuerfel.Bierkarte.class, true);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.wuerfelaugenSetzen(42);
		assertEquals(user.wuerfelAnkucken(), 42);
	}
	
	public void testBierdeckel()
	{
		// TODO: Mock that shit
	}
	
	public void testKneipe()
	{
		Bier bier = new Bier(1);

		// TODO: debug
		/*
		try {
			user.geheInKneipe("freiburger_bierhaus");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		assertEquals(user.sucheNameVonBier(bier), "Testbier");
		assertEquals(user.sucheAlcVonBier(bier), 5.00F);
		assertEquals(user.suchePreisVonBier(bier), 2.50F);
		*/
	}
}
