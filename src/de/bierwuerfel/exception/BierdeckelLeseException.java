package de.bierwuerfel.exception;

public class BierdeckelLeseException extends Exception
{
	public String toString()
	{
		return "Fehler beim auslesen des Bierdeckels :(\n";
	}
}
