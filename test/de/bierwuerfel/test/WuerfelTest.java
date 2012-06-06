package de.bierwuerfel.test;


import org.junit.Before;

import de.bierwuerfel.Wuerfel;
import junit.framework.TestCase;

public class WuerfelTest extends TestCase
{
	Wuerfel wuerfel;
	
	public void setUp() throws Exception 
	{
		wuerfel = new Wuerfel();
	}

	public void testMax()
	{
		assertEquals(wuerfel.getMax(), 120);
		
		wuerfel.setMax(23);
		assertEquals(wuerfel.getMax(), 23);
	}
	
	public void testWuerfeln()
	{
		wuerfel.setMax(23);
		
		for(int i=0; i<10; i++)
		{
			assertEquals(wuerfel.roll() < 23, true);
		}				
	}
}
