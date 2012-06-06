package de.bierwuerfel.view;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import de.enough.polish.ui.UiAccess;

import de.bierwuerfel.Bierwuerfel;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code - The Config form
 * Configure everythin of interest
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

public class ConfigForm extends Form implements CommandListener
{
	private Command configCommand = new Command("Config", Command.SCREEN, 1);
	private Command configZurueckCommand = new Command("Zurueck", Command.BACK, 1);
	private Command wuerfelaugenSetzenCommand = new Command("Aendern", Command.ITEM, 1);
	
	private Bierwuerfel midlet;
	private Display display;
	
	private ConfigDiceForm configDiceForm;
	
	
	/*
	 * Constructor of Config Form
	 */
	public ConfigForm(Bierwuerfel m) 
	{
		super(m.titel);

		midlet = m;
		display = Display.getDisplay(m);
		
        // Construct config submenu
        UiAccess.addSubCommand(configZurueckCommand, this.configCommand, this);
        UiAccess.addSubCommand(wuerfelaugenSetzenCommand, this.configCommand, this);
        setCommandListener(this);        
    	
    	append("Wuerfelaugen: " + midlet.user.wuerfelAnkucken());
    	
    	// Construct sub forms
    	configDiceForm = new ConfigDiceForm(midlet);
	}
	

	/*
	 * Eventhandler for menu
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command c, Displayable d) 
	{
        // Configure dice
        if(c == wuerfelaugenSetzenCommand)
        {        	
        	display.setCurrent(configDiceForm);
        }

        // Show main form
        else if(c == configZurueckCommand)
        {
        	display.setCurrent( midlet.mainForm );
        }
	}
}

// EOF dude.