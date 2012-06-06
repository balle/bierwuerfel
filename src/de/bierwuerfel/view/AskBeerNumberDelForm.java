package de.bierwuerfel.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

import de.bierwuerfel.Bierwuerfel;
import de.bierwuerfel.dao.bier.BierDAOInterface;
import de.bierwuerfel.exception.BierLoeschException;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code - Form to ask the user for a beer number and ERASE it's life!
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

public class AskBeerNumberDelForm extends AskBeerNumberForm implements CommandListener
{	
	/*
	 * Constructor
	 */
	public AskBeerNumberDelForm(Bierwuerfel m, BierDAOInterface b) 
	{
		super(m, b);
	}

	
	/*
	 * Eventhandler for buttons
	 * @see de.bierwuerfel.view.AskBeerNumberForm#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 * @override
	 */
	public void commandAction(Command c, Displayable d) 
	{
		if(c == biernummerOkCommand)
		{
			if(biernummerEingabe != null)
			{
				// Delete beer with given number
	        	try
	        	{
					int deleted = midlet.user.bierMitNrLoeschen( Integer.parseInt(this.biernummerEingabe), bierdeckel );
					midlet.showInfo(deleted + " Bier geloescht!\n");
				}
	        	catch (Throwable e)
	        	{
	        		midlet.showError(new BierLoeschException().toString() +
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