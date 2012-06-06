package de.bierwuerfel.test;


import org.junit.Before;
import junit.framework.TestCase;
import de.bierwuerfel.Bierkarte;

public class BierkarteTest extends TestCase
{
	Bierkarte bierkarte;
	
	public void setUp() 
	{
		bierkarte = new Bierkarte();
		try {
			bierkarte.parse("freiburger_bierhaus");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void testParse() throws Throwable
	{
		bierkarte.parse("freiburger_bierhaus");
	}
	
	public void testName()
	{
		assertEquals(bierkarte.getName(1), "Testbier");
		assertEquals(bierkarte.getName(2), "Testbier 2");
	}
	
	public void testPrice()
	{
		assertEquals(bierkarte.getPrice(1), 2.50F);
		assertEquals(bierkarte.getPrice(2), 2.20F);
	}
	
	public void testAlc()
	{
		assertEquals(bierkarte.getAlc(1), 5.00F);
		assertEquals(bierkarte.getAlc(1), 4.70F);
	}
}
