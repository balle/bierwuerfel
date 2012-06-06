/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * Eine klasse Klasse, die Bierkarten XML Dateien parst und sich
 * die Biere anhand ihrer Nummer in einem Index merkt
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

package de.bierwuerfel;

import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class Bierkarte extends DefaultHandler
{
	private String name;
	private Hashtable bierMap;
	private int bierNr;
	private String bierName;
	private float bierPrice;
	private float bierAlc;
	private String currentTag;

	
	/*
	 * Constructor
	 */
	public Bierkarte()
	{
		super();
	}

	
	/*
	 * Parse a bierkarte xml file
	 * @param name of pub (or filename without .xml)
	 */
	public void parse(String name) throws Throwable
	{
		this.name = name;

		DefaultHandler handler = new Bierkarte();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//factory.setNamespaceAware(true);
		//factory.setValidating(true);

		SAXParser parser = factory.newSAXParser();
		InputSource input = new InputSource("res/bierkarte/" + this.name + ".xml");

		if(input != null && handler != null && parser != null)
		{
			parser.parse(input, handler);
		}
		//parser.parse(new InputSource("bierkarte/" + this.name + ".xml"), handler);
	}

	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException
	{
		super.startElement(uri, localName, tag, attributes);
		currentTag = tag;

		if(tag == "bier")
		{
			bierNr = 0;
			bierName = "Unbekanntes Bier";
			bierPrice = -1;
			bierAlc = -1;
		}		
	}

	public void characters(char[] ch, int start, int length) throws SAXException
	{
		super.characters(ch, start, length);
		
		String value = new String(ch, start, length);		
	    byte[] test = value.getBytes();
		boolean isEmpty = true;

		for(int i=0; i<test.length; i++)
		{
			if(test[i] != 9 && test[i] != 10)
			{
				isEmpty = false;
				break;
			}
		}

		if( ! isEmpty)
		{
			System.out.println("CurrentTag: " + currentTag + " Value: -" + value + "-");
			
			if(currentTag == "number")
			{
				bierNr = Integer.parseInt(value);
			}
			else if(currentTag == "name")
			{
				bierName = value;
			}
			else if(currentTag == "price")
			{
				bierPrice = Float.parseFloat(value);
			}
			else if(currentTag == "alc")
			{
				bierAlc = Float.parseFloat(value);
			}
		}
	}

	public void endElement(String uri, String localName, String tag) throws SAXException
	{
		super.endElement(uri, localName, tag);

		if(tag == "bier" && bierNr != 0)
		{
			System.out.println("BierNr " + bierNr);
			Bier bier = new Bier(bierNr);
			bier.setName(bierName);
			bier.setPrice(bierPrice);
			bier.setAlc(bierAlc);

			bierMap.put( String.valueOf(bierNr), bier);
		}
	}

	
	/*
	 * get name of beer
	 * @return string
	 */
	public String getName(int nr)
	{
		Bier bier = (Bier)bierMap.get(String.valueOf(nr));
		return bier.getName();
	}

	
	/*
	 * get price of beer
	 * @return float
	 */
	public float getPrice(int nr)
	{
		Bier bier = (Bier)bierMap.get(String.valueOf(nr));
		return bier.getPrice();
	}

	
	/*
	 * get alc of beer
	 * @return float
	 */
	public float getAlc(int nr)
	{
		Bier bier = (Bier)bierMap.get(String.valueOf(nr));
		return bier.getAlc();
	}
}
