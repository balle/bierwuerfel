package de.bierwuerfel.dao.bier;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * Interface fuer Bierdeckel
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

import de.bierwuerfel.Bier;

public interface Interface
{
	/*
	 * Save a beer 
	 * @param bier
	 */
	public int set(Bier bier) throws Throwable;

	/*
	 * Retrieve all beer
	 * @return array of beer objects
	 */
	public Bier[] get() throws Throwable;

	/*
	 * Delete a beer by its number
	 * @param integer
	 */
	public int del(int nr) throws Throwable;

	/*
	 * Delete all beer
	 */
	public void format() throws Throwable;
}
