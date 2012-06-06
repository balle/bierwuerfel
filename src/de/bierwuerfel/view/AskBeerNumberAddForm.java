package de.bierwuerfel.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

import de.bierwuerfel.Bier;
import de.bierwuerfel.Bierwuerfel;
import de.bierwuerfel.dao.bier.BierDAOInterface;
import de.bierwuerfel.exception.BierSpeicherException;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code - Form to ask the user for a beer number and throw it
 * into the real pool of livin beings aka DRINK and REMEMBER it!
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

public class AskBeerNumberAddForm extends AskBeerNumberForm implements CommandListener
{
	/*
	 * Constructor
	 */
	public AskBeerNumberAddForm(Bierwuerfel m, BierDAOInterface b) 
	{
		super(m, b);
	}

	
	/*
	 * Eventhandler for buttons
	 * @see de.bierwuerfel.view.AskBeerNumberForm#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command c, Displayable d) 
	{
		if(c == biernummerOkCommand)
		{
			if(biernummerEingabe != null)
			{
				// Add beer with given number
	        	try
	        	{
	        		Bier bier = new Bier( Integer.parseInt(this.biernummerEingabe) );
	        		midlet.user.bierSpeichern(bier, bierdeckel);
	        		midlet.showInfo("Bier gespeichert.\n");
				}
	        	catch (Throwable e)
	        	{
	        		midlet.showError(new BierSpeicherException().toString() +
	        						 e.toString());
				}
			}
		}
		
        // Back to main form
        else if(c == biernummerZurueckCommand)
        {
        	display.setCurrent( midlet.mainForm );
        }

	}

}

// EOF dude.