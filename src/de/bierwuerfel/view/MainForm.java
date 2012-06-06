package de.bierwuerfel.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import de.enough.polish.ui.UiAccess;
import de.bierwuerfel.Bierwuerfel;
import de.bierwuerfel.exception.AlleBiereSindDoofException;
import de.bierwuerfel.exception.BierSpeicherException;
import de.bierwuerfel.exception.WuerfelException;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code - This is the MAIN form!
 * Adore it! Hrrhrr
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */


public class MainForm extends Form implements CommandListener
{
	 private final Command createMenuCommand = new Command("Menu", Command.SCREEN, 1 );
    private Command trinkCommand = new Command("Bier trinken", Command.ITEM, 1);    
    private Command buhBierCommand = new Command("Bier baeh!", Command.ITEM, 1);
    private Command wuerfelCommand = new Command("Wuerfeln", Command.ITEM, 1);
    private Command bierdeckelMenuCommand = new Command("Bierdeckel...", Command.ITEM, 1);
    private Command doofesBierMenuCommand = new Command("Doofes Bier...", Command.ITEM, 1);
    private Command configMenuCommand = new Command("Config...", Command.ITEM, 1);
    private Command aboutCommand = new Command("About", Command.ITEM, 1);
    private Command exitCommand = new Command("Exit", Command.EXIT, 1);    

    private BierdeckelForm bierdeckelForm;
    private BierdeckelForm buhbierdeckelForm;
    private ConfigForm configForm;
    private AboutForm aboutForm;
    
    private Bierwuerfel midlet;
    private Display display;
    
    
    /*
     * Constructor of main menu
     */
	public MainForm(Bierwuerfel m) 
	{
		super(m.titel);
        midlet = m;
        display = Display.getDisplay(m);
        
        try
        {
        	// This will automatically choose the right bierkarte object
			midlet.user.geheInKneipe("freiburger_bierhaus");
		}
        catch (Throwable error)
        {
			append(error.getMessage());
		}

        // Construct main menu
        UiAccess.addSubCommand(trinkCommand, this.createMenuCommand, this);
        UiAccess.addSubCommand(wuerfelCommand, this.createMenuCommand, this);
        UiAccess.addSubCommand(buhBierCommand, this.createMenuCommand, this);
        UiAccess.addSubCommand(bierdeckelMenuCommand, this.createMenuCommand, this);
        UiAccess.addSubCommand(doofesBierMenuCommand, this.createMenuCommand, this);
        UiAccess.addSubCommand(configMenuCommand, this.createMenuCommand, this);
        UiAccess.addSubCommand(aboutCommand, this.createMenuCommand, this);
        UiAccess.addSubCommand(exitCommand, this.createMenuCommand, this);
        setCommandListener(this);

        // Construct sub forms    	
    	configForm = new ConfigForm(midlet);
    	aboutForm = new AboutForm(midlet); 
	}
        

	/*
	 * Eventhandler for buttons
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command c, Displayable d) 
	{
        // Drink beer :)
        if(c == trinkCommand)
        {
        	try
        	{
				midlet.user.bierSpeichern(midlet.bier, midlet.user.getBierdeckel());
				midlet.showInfo("Prost!\n");
				midlet.mainForm.deleteAll();
				midlet.mainForm.append("Bier Nr: " + midlet.bier.getNumber() + " getrunken.\n");
			}
        	catch (Throwable e)
        	{
        		midlet.showError(new BierSpeicherException().toString() +
        						 e.toString());
			}
        }

        // Got ugly beer?
        else if(c == buhBierCommand)
        {
        	try {
				midlet.user.bierSpeichern(midlet.bier, midlet.user.getBuhbierdeckel());
				midlet.showInfo("Doofes Bier gemerkt :)");
			} 
        	catch (Throwable e) 
			{
        		midlet.showError(new BierSpeicherException().toString() +
        						 e.toString());
			}
        }

        // Dice, baby!
        else if(c == wuerfelCommand)
        {
        	try
        	{
				midlet.bier = midlet.user.wuerfeln();
				
	        	// TODO: Debug here
	        	// sucheNameVonBier liefert null pointer exception
	        	//bier.setNumber(1);
				deleteAll();
	            append("Bier Nr: " +  midlet.bier.getNumber() + "\n");
	            //mainForm.append("Name: " +  user.sucheNameVonBier(bier) + "\n");
			}
        	catch(AlleBiereSindDoofException b)
        	{
        		midlet.showError(b.toString());
        	}
        	catch (Throwable e)
			{        		
        		midlet.showError(new WuerfelException().toString() +
								 e.toString());
			}
        }

        // Bierdeckel Submenu
        else if(c == bierdeckelMenuCommand)
        {
        	bierdeckelForm = new BierdeckelForm(midlet, midlet.user.getBierdeckel());
        	display.setCurrent( bierdeckelForm );
        }

        // doofes Bier Submenu
        else if(c == doofesBierMenuCommand)
        {
        	buhbierdeckelForm = new BierdeckelForm(midlet, midlet.user.getBuhbierdeckel());
        	display.setCurrent( buhbierdeckelForm );
        }

        // Config Submenu
        else if(c == configMenuCommand)
        {
        	display.setCurrent(configForm);
        }

        // About
        else if(c == aboutCommand)
        {
        	display.setCurrent(aboutForm);
        }
        
    	// Exit Program
        else if (c == exitCommand)
        {
        	midlet.notifyDestroyed();
        }
	}
}

// EOF dude.