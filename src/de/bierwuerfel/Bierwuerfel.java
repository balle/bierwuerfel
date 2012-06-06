package de.bierwuerfel;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import de.bierwuerfel.view.MainForm;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * UI code aka The View[tm]
 * This is the Main midlet
 * It constructs the User object (aka the Controller) and the MainForm
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

public final class Bierwuerfel extends MIDlet
{
    private Display display;
    public Form mainForm;
    
    public Bier bier;
    public User user;
    public String titel = "Bierwuerfel 0.6";

    // Constructor
    public Bierwuerfel()
    {
    	display = Display.getDisplay(this);
    	user = new User();    	
    }

    // Start the application
    protected void startApp()
    {
    	// Show main form
    	mainForm = new MainForm(this);
    	display.setCurrent(mainForm);

    	// Dice a beer!
    	try
    	{
    		Bier[] biere = user.bierdeckelAnzeigen(user.getBierdeckel());
    		
    		if(biere.length > 0)
    		{
    			mainForm.append("Dein Bierdeckel ist nicht leer.");
    		}
    		
			bier = user.wuerfeln();
			mainForm.append("Bier Nr: " +  bier.getNumber() + "\n");
		}
    	catch (Throwable e){}
    }

    // Pause the application
    protected void pauseApp() {}

    // Destructor
    protected void destroyApp(boolean unconditional) {}
    
    // Show an error message
    public void showError(String msg)
    {
		Alert alert = new Alert("Error");
		alert.setType(AlertType.ERROR);
		alert.setString(msg);
		display.setCurrent(alert, mainForm);
    }

    // Show an info message
    public void showInfo(String msg)
    {
		Alert alert = new Alert("Info");
		alert.setType(AlertType.INFO);
		alert.setString(msg);
		display.setCurrent(alert, mainForm);
    }
}

// EOF dude.