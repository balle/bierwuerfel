package de.bierwuerfel.exception;

public class WuerfelException extends Exception
{
	public String toString()
	{
		return "Die Wuerfel sind gefallen!\n" +
		 		"Ich weiss nur nicht wohin :(\n";
	}
}
