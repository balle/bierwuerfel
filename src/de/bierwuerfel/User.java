package de.bierwuerfel;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * Controller
 *
 * geht in Kneipe, wuerfelt, liest Bierkarte, trinkt Bier merkt sich
 * welches Bier nicht so lecker war und managed nebenbei noch den
 * Bierdeckel
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

// TODO: bier dbs sowie xmls sollten alle unter kneipe/name sein
// Denn die Kneipe ist der Mittelpunkt. Zu ihr gehoert die Bierkarte,
// der Bierdeckel und die doofen Biere

import de.bierwuerfel.dao.bier.*;
import de.bierwuerfel.exception.AlleBiereSindDoofException;

public class User {

	private Wuerfel wuerfel;
	private BierDAOInterface bierdeckel;
	private BierDAOInterface buhbierdeckel;
	private Kneipe kneipe;

	/*
	 * Constructor
	 */
	public User()
	{
		this.wuerfel = new Wuerfel();

		try
		{
			//bierdeckel = new BierDAOFloggy();
			bierdeckel = new BierDAORecordStore("bier.db");
			buhbierdeckel = new BierDAORecordStore("buhbier.db");
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	
	/*
	 * Dice a beer but ignore the one we dont like
	 * @return Bier 
	 */
	public Bier wuerfeln() throws Throwable
    {
		Bier buhbiere[] = buhbierdeckel.get();

		if(buhbiere.length >= wuerfel.getMax())
		{
			throw new AlleBiereSindDoofException();
		}
		
		while(true)
		{
			int bierNr = wuerfel.roll();
			boolean bierDoof = false;
			
			for(int i=0; i<buhbiere.length; i++)
			{			
				if(buhbiere[i].getNumber() == bierNr)
				{
					bierDoof = true;
				}
			}
			
			if( ! bierDoof)
			{
				return new Bier(bierNr);
			}
		}		
    }

	
	/*
	 * Drink a beer :)
	 * And well remember that
	 * @param bier
	 */
    public void bierSpeichern(Bier bier, BierDAOInterface bierdeckel) throws Throwable
    {
		bierdeckel.set(bier);
    }

    
    /*
     * Show ugly beer
     * @return array of bier
     */
    public Bier[] bierdeckelAnzeigen(BierDAOInterface bierdeckel) throws Throwable
    {
		return bierdeckel.get();
    }

    
    /*
     * Forget what we drunk
     */
    public void bierdeckelLoeschen(BierDAOInterface bierdeckel) throws Throwable
    {
		bierdeckel.format();
    }


    /* 
     * Delete a beer with the given number
     * @param integer
     */
    public int bierMitNrLoeschen(int nr, BierDAOInterface bierdeckel) throws Throwable
    {
    	return bierdeckel.del(nr);
    }

    
    /*
     * Configure the dice max number
     * @param integer
     */
    public void wuerfelaugenSetzen(int number)
    {
    	this.wuerfel.setMax(number);
    }

    
    /*
     * Show dice max number
     * @return integer
     */
    public int wuerfelAnkucken()
    {
    	return this.wuerfel.getMax();
    }

    
    /*
     * Remember in what pub we are
     * @param name of pub
     */
    public void geheInKneipe(String name) throws Throwable
    {
    	kneipe = new Kneipe(name);
    }

    
    /*
     * Search the name of a given beer
     * @param bier
     * @return name
     */
    public String sucheNameVonBier(Bier bier)
    {
    	return this.kneipe.getBierkarte().getName( bier.getNumber() );
    }

    
    /*
     * Search price of a given beer
     * @param bier
     * @return price as float
     */
    public float suchePreisVonBier(Bier bier)
    {
    	return this.kneipe.getBierkarte().getPrice( bier.getNumber() );
    }


    /*
     * Search alc of a given beer
     * @param bier
     * @return alc as float
     */    
    public float sucheAlcVonBier(Bier bier)
    {
    	return this.kneipe.getBierkarte().getAlc( bier.getNumber() );
    }


	public BierDAOInterface getBierdeckel() {
		return bierdeckel;
	}


	public void setBierdeckel(BierDAOInterface bierdeckel) {
		this.bierdeckel = bierdeckel;
	}


	public BierDAOInterface getBuhbierdeckel() {
		return buhbierdeckel;
	}


	public void setBuhbierdeckel(BierDAOInterface buhbierdeckel) {
		this.buhbierdeckel = buhbierdeckel;
	}    
}
