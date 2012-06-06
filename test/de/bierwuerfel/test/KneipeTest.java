package de.bierwuerfel.test;

import junit.framework.TestCase;

import org.junit.*;

import de.bierwuerfel.Kneipe;

public class KneipeTest extends TestCase
{
	Kneipe kneipe;
	
	public void setUp() throws Exception 
	{
		try {
			kneipe = new Kneipe("freiburger_bierhaus");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testName()
	{
		assertEquals(kneipe.getName(), "Freiburger Bierhaus");
	}

	public void testAdresse()
	{
		assertEquals(kneipe.getAdresse(), "teststr 23");
	}
	
	public void testBierkarte()
	{
		// TODO: debug
		//assertEquals(kneipe.getBierkarte(), de.bierwuerfel.Bierkarte);
	}
	
	public void testLatitude()
	{
		assertEquals(kneipe.getLatitude(), 0.00F);
	}

	public void testLongitude()
	{
		assertEquals(kneipe.getLongitude(), 0.00F);
	}

	public void testOeffnungszeiten()
	{
		assertEquals(kneipe.getOeffnungszeiten(), "17-02 uhr");
	}

	public void testTelefon()
	{
		assertEquals(kneipe.getTelefon(), "1234 567890");
	}
}
