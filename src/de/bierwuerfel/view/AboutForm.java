package de.bierwuerfel.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import de.bierwuerfel.Bierwuerfel;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code - Just a silly form that tells you about the origin of
 * this stupid code and whom to blame for it
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

public class AboutForm extends Form implements CommandListener
{
	private Command okCommand = new Command("Ok", Command.BACK, 1);
	private Bierwuerfel midlet;
	private Display display;

	
	/*
	 * Constructor
	 */
	public AboutForm(Bierwuerfel m) 
	{
		super(m.titel);
	
		midlet = m;
		display = Display.getDisplay(m);
    
		append("Programmed by Balle :)\nwww.deutschlandcomic.de\n");

    	addCommand(okCommand);
    	setCommandListener(this);
	}

	
	/*
	 * Eventhandler for buttons
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command c, Displayable d) 
	{
		if (c == okCommand)
        {
        	display.setCurrent( midlet.mainForm );
        }
	}
}

// EOF dude.