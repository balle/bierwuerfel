package de.bierwuerfel.exception;

public class BierLoeschException extends Exception
{
	public String toString()
	{
		return "Fehler beim loeschen des Bieres!\n";
	}
}
