package de.bierwuerfel.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextField;

import de.bierwuerfel.Bierwuerfel;


/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code - Config dice form
 * The dice is WILD! Try to repress it.
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

public class ConfigDiceForm extends Form implements ItemStateListener, CommandListener
{
	private Command wuerfelaugenOkCommand = new Command("Ok", Command.ITEM, 1);
    private String wuerfelaugenEingabe;
    
    private Bierwuerfel midlet;
    private Display display;

    
    /*
     * Constructor of ConfigDice form
     */
	public ConfigDiceForm(Bierwuerfel m) 
	{
		super(m.titel);

		midlet = m;
		display = Display.getDisplay(m);
		
		// Create text input field
    	TextField tf = new TextField("Max. Zahl eingeben: ", "", 3, TextField.DECIMAL);    	    	
    	append(tf);
    	setItemStateListener(this);
    	
    	addCommand(wuerfelaugenOkCommand);
    	setCommandListener(this);
	}

	
	/*
	 * Eventhandler for buttons
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command c, Displayable d) 
	{
		if(c == wuerfelaugenOkCommand)
		{
			if(wuerfelaugenEingabe != null)
			{
				midlet.user.wuerfelaugenSetzen( Integer.parseInt(wuerfelaugenEingabe) );
				display.setCurrent( midlet.mainForm );
			}
		}
	}

	
	/*
	 * Eventhandler for text input field
	 * @see javax.microedition.lcdui.ItemStateListener#itemStateChanged(javax.microedition.lcdui.Item)
	 */
	public void itemStateChanged(Item item) 
	{
		if(item instanceof TextField)
		{
			wuerfelaugenEingabe = ((TextField)item).getString();
		}
	}
}

// EOF dude.