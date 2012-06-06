package de.bierwuerfel;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * The object of desire
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

//import net.sourceforge.floggy.persistence.Persistable;

public class Bier //implements Persistable
{
	private int number;
	private String name;
	private float price;
	private float alc;

	
	/*
	 * Constructor
	 * @param number of beer in beer list
	 */
	public Bier(int number) {
		this.number = number;
		this.name = "Unbekannte Biersorte";
		this.price = 0;
		this.alc = -1;
	}

	
	/*
	 * get name of beer
	 * @return string
	 */
	public String getName() {
		return name;
	}

	
	/*
	 * get number of beer
	 * @return integer
	 */
	public int getNumber() {
		return number;
	}

	
	/*
	 * get price of beer
	 * @return float
	 */
	public float getPrice() {
		return price;
	}

	
	/* 
	 * get alc of beer
	 * @return float
	 */
	public float getAlc() {
		return alc;
	}

	
	/*
	 * set name of beer
	 * @param string
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/*
	 * set number of beer
	 * @param integer
	 */
	public void setNumber(int nr) {
		this.number = nr;
	}

	
	/*
	 * set price of beer
	 * @param float
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	
	/*
	 * set alc of beer
	 * @param float
	 */
	public void setAlc(float alc) {
		this.alc = alc;
	}
}
