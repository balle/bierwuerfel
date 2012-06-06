package de.bierwuerfel;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * Eine Kneipe und deren (un)typischen Eigenschaften
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

public class Kneipe
{
	private String name;
	private Bierkarte bierkarte;
	private float latitude;
	private float longitude;
	private String adresse;
	private String telefon;
	private String oeffnungszeiten;

	
	/*
	 * Constructor
	 * @param name as string
	 */
	public Kneipe(String name) throws Throwable
	{
		this.name = name;
		this.bierkarte = new Bierkarte();
		this.bierkarte.parse(name);
	}

	
	/*
	 * get address
	 * @return address as string
	 */
	public String getAdresse() {
		return adresse;
	}

	
	/*
	 * set the address
	 * @param address as string
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	/*
	 * get the list of beer
	 * @return bierkarte object
	 */
	public Bierkarte getBierkarte() {
		return this.bierkarte;
	}

	
	/*
	 * set the list of beer
	 * @param bierkarte object
	 */
	public void setBierkarte(Bierkarte bierkarte) {
		this.bierkarte = bierkarte;
	}

	
	/*
	 * get latitude of pub
	 * @return float
	 */
	public float getLatitude() {
		return latitude;
	}

	
	/*
	 * set latitude of pub
	 * @param float
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	
	/*
	 * get longitude of pub
	 * @return float
	 */
	public float getLongitude() {
		return longitude;
	}

	
	/*
	 * set longitude of pub
	 * @return float
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	
	/*
	 * get name of pub
	 * @return name as string
	 */
	public String getName() {
		return name;
	}

	
	/*
	 * set name of pub
	 * @param name as string
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/*
	 * get business hours of pub
	 * @return string
	 */
	public String getOeffnungszeiten() {
		return oeffnungszeiten;
	}

	
	/*
	 * set business hours of pub
	 * @param string
	 */
	public void setOeffnungszeiten(String oeffnungszeiten) {
		this.oeffnungszeiten = oeffnungszeiten;
	}

	
	/*
	 * get phone number of pub
	 * @return string
	 */
	public String getTelefon() {
		return telefon;
	}

	
	/*
	 * set phone number of pub
	 * @param string
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}
