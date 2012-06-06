package de.bierwuerfel.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.rms.RecordStoreException;

import de.enough.polish.ui.UiAccess;

import de.bierwuerfel.*;
import de.bierwuerfel.dao.bier.BierDAOInterface;
import de.bierwuerfel.exception.BierdeckelLeseException;
import de.bierwuerfel.exception.BierdeckelLoeschException;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code - The Bierdeckel form + menu
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

public class BierdeckelForm extends Form implements CommandListener
{
	private Command bierdeckelCommand = new Command("Bierdeckel", Command.SCREEN, 1);
	protected Command bierdeckelAnzeigeCommand = new Command("Anzeigen", Command.ITEM, 1);
	protected Command bierdeckelLoeschCommand = new Command("Zerreissen", Command.ITEM, 1);    
	protected Command bierdeckelZurueckCommand = new Command("Zurueck", Command.BACK, 1);
	protected Command biernummerSetzenCommand = new Command("Bier mit Nr speichern", Command.ITEM, 1);
	protected Command biernummerLoeschenCommand = new Command("Bier mit Nr loeschen", Command.ITEM, 1);

	protected AskBeerNumberForm delConfForm;
	protected AskBeerNumberForm addConfForm;
    
	protected Bierwuerfel midlet;
	protected Display display;
	private BierDAOInterface bierdeckel;
    

    /*
     * Constructor of Bierdeckel form
     */
    public BierdeckelForm(Bierwuerfel m, BierDAOInterface b)
    {
    	super(m.titel);
    	
    	midlet = m;
    	display = Display.getDisplay(m);
    	bierdeckel = b;
    	
        // Construct menu
        UiAccess.addSubCommand(bierdeckelAnzeigeCommand, this.bierdeckelCommand, this);
        UiAccess.addSubCommand(bierdeckelLoeschCommand, this.bierdeckelCommand, this);
        UiAccess.addSubCommand(biernummerSetzenCommand, this.bierdeckelCommand, this);
        UiAccess.addSubCommand(biernummerLoeschenCommand, this.bierdeckelCommand, this);
        UiAccess.addSubCommand(bierdeckelZurueckCommand, this.bierdeckelCommand, this);
        
        // Construct sub forms
    	delConfForm = new AskBeerNumberDelForm(midlet, bierdeckel);
    	addConfForm = new AskBeerNumberAddForm(midlet, bierdeckel);
    	
	    setCommandListener(this);                	       
		showBeer();
	}

	/*
	 * Eventhandler for menu
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command c, Displayable d) 
	{
        // Look what we drunk
        if(c == bierdeckelAnzeigeCommand)
        {
        	showBeer();
        }

        // Forget what we drunk
        else if(c == bierdeckelLoeschCommand)
        {
        	try
        	{
				midlet.user.bierdeckelLoeschen(bierdeckel);
				midlet.showInfo("Dein Bierdeckel wurde erfolgreich zerrissen :)\n");
			}
        	catch (RecordStoreException e)
        	{
        		midlet.showError(new BierdeckelLoeschException().toString() +
        						 e.toString());
        	}
        	catch (Throwable e)
        	{
        		midlet.showError(new BierdeckelLoeschException().toString() +
        						 e.toString());
        	}
        }

        // Set number of beer and drink it
        else if(c == biernummerSetzenCommand)
        {
        	display.setCurrent(addConfForm);        	
        }

        // Set number of beer and delete it
        else if(c == biernummerLoeschenCommand)
        {
        	display.setCurrent(delConfForm);
        }
        
        // Back to main form
        else if(c == bierdeckelZurueckCommand)
        {
        	display.setCurrent( midlet.mainForm );
        }
	}

	
    /*
     * Show all beer we drunk
     */
	public void showBeer() 
	{
    	Bier[] bierListe;
    	
    	try
		{
			bierListe = midlet.user.bierdeckelAnzeigen(bierdeckel);

			if(bierListe.length == 0)
			{
				append("Dein Bierdeckel ist leer.");
			}
			else
			{
				append("Dein Bierdeckel enthaelt folgendes:\n");

	    		for(int x = 0; x <= bierListe.length-1; x++)
	    		{
	    			append("Bier Nr:" + bierListe[x].getNumber() + "\n");
	    		}
			}
		}
    	catch (RecordStoreException r)
    	{
    		midlet.showError(new BierdeckelLeseException().toString() +
    						 r.toString());
		}
    	catch (Throwable e)
    	{
    		midlet.showError(new BierdeckelLeseException().toString() +
    						 e.toString());
    	}
	}
}

// EOF dude.