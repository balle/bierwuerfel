package de.bierwuerfel;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * Das is das Objekt was rumrollt und den Zufall erzeugt
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

import java.util.Random;

public class Wuerfel {
	private int max;

	
	/*
	 * Constructor
	 */
	public Wuerfel() {
		this.max = 120;
	}

	
	/*
	 * get max number
	 * @return integer
	 */
	public int getMax() {
		return max;
	}

	
	/*
	 * set max number
	 * @param integer
	 */
	public void setMax(int max) {
		this.max = max;
	}

	
	/*
	 * roll the dice and get a random number
	 */
	public int roll()
	{
		Random r = new Random();
		return r.nextInt(this.max) + 1;
	}
}

// EOF dude.