package de.bierwuerfel.dao.bier;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * Bierdeckel, der in eine OO-Db speichert
 * Funzt zur Zeit nicht :(
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.ObjectSet;
import net.sourceforge.floggy.persistence.PersistableManager;
import de.bierwuerfel.Bier;

public class BierDAOFloggy implements BierDAOInterface {

	public BierDAOFloggy() {}

	/*
	 * @see de.bierwuerfel.dao.bier.Interface#format()
	 */
	public void format() throws Throwable
	{
		ObjectSet objects = PersistableManager.getInstance().find(Bier.class, null, null);

		for (int i = 0; i < objects.size(); i++)
		{
			//PersistableManager.getInstance().delete((Bier)objects.get(i));
		}
	}

	
	/*	 
	 * @see de.bierwuerfel.dao.bier.Interface#get()
	 */
	public Bier[] get() throws Throwable
	{
		ObjectSet objects = PersistableManager.getInstance().find(Bier.class, null, null);
		Bier[] bierList = new Bier[objects.size()];

		for (int i = 0; i < objects.size(); i++)
		{
			bierList[i] = (Bier)objects.get(i);
		}

		return bierList;
	}

	
	/*
	 * @see de.bierwuerfel.dao.bier.Interface#set(de.bierwuerfel.Bier)
	 */
	public int set(Bier bier) throws Throwable
	{
		int id = -1;

		/*
		try
		{
			//id = PersistableManager.getInstance().save(bier);
		}
		catch(FloggyException e)
		{
			e.printStackTrace();
		}
		*/
		return id;
	}

	
	/*
	 * @see de.bierwuerfel.dao.bier.Interface#del(int)
	 */
	public int del(int nr) throws Throwable {
		// TODO Auto-generated method stub
		return 0;
	}

}
