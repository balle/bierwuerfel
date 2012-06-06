package de.bierwuerfel.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.ItemStateListener;

import de.bierwuerfel.Bier;
import de.bierwuerfel.Bierwuerfel;
import de.bierwuerfel.dao.bier.BierDAOInterface;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code - Form to ask the user for a beer number
 * This is just a base class.
 * Other classes like AskBeerNumberAddForm and AskBeerNumberDelForm
 * inherit from this one to do their evil work.
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */


public class AskBeerNumberForm extends Form implements ItemStateListener,  CommandListener
{
    protected Command biernummerOkCommand = new Command("Ok", Command.ITEM, 1);    
    protected Command biernummerZurueckCommand = new Command("Zurueck", Command.BACK, 1);
    protected String biernummerEingabe;
    
    protected Bierwuerfel midlet;
	protected Display display;
	protected BierDAOInterface bierdeckel;
	private Bier bier;

	
	/*
	 * Constructor
	 */
	public AskBeerNumberForm(Bierwuerfel m, BierDAOInterface b) 
	{
		super(m.titel);
		
		midlet = m;
		display = Display.getDisplay(m);
		bierdeckel = b;
		
		// Create text input field
    	TextField tf = new TextField("Zahl eingeben: ", "", 3, TextField.DECIMAL);
    	append(tf);
    	setItemStateListener(this);
    	
    	addCommand(biernummerOkCommand);
    	addCommand(biernummerZurueckCommand);
    	setCommandListener(this);
	}

	
	/*
	 * Eventhandler for text input field
	 * @see javax.microedition.lcdui.ItemStateListener#itemStateChanged(javax.microedition.lcdui.Item)
	 */
	public void itemStateChanged(Item item) 
	{
		if(item instanceof TextField)
		{
			biernummerEingabe = ((TextField)item).getString();
		}
	}

	
	/*
	 * Eventhandler for buttons
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command c, Displayable d) 
	{
		if(c == biernummerOkCommand)
		{
			if(biernummerEingabe != null)
			{
				bier.setNumber( Integer.parseInt(biernummerEingabe) );
			}
		}
	}
}

// EOF dude.