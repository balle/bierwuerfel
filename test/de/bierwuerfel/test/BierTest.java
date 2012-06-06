package de.bierwuerfel.test;

import de.bierwuerfel.Bier;
import junit.framework.TestCase;

public class BierTest extends TestCase 
{
	Bier bier;
	
	public BierTest() 
	{
		bier = new Bier(1);
		assertEquals(bier.getNumber(),1);
	}
	
	public void testNumber()
	{
		bier = new Bier(1);
		assertEquals(bier.getNumber(),1);
		
		bier.setNumber(23);
		assertEquals(bier.getNumber(), 23);
	}
	
	public void testName()
	{
		bier = new Bier(1);
		assertEquals(bier.getName(), "Unbekannte Biersorte");
		
		bier.setName("testbier");
		assertEquals(bier.getName(), "testbier");
	}
	
	public void testAlc()
	{
		bier = new Bier(1);
		assertEquals(bier.getAlc(), -1.0F);
		
		bier.setAlc(5.2F);
		assertEquals(bier.getAlc(), 5.2F);		
	}
	
	public void testPrice()
	{
		bier = new Bier(1);
		assertEquals(bier.getPrice(), 0.0F);
		
		bier.setPrice(2.00F);
		assertEquals(bier.getPrice(), 2.00F);
	}
}
