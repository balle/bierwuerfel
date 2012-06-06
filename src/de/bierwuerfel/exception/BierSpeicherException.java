package de.bierwuerfel.exception;

public class BierSpeicherException extends Exception
{
	public String toString()
	{
		return "Fehler beim speichern des Bieres!\n" +
		 		"Moegliche Ursachen:\n" +
		 		"Kein Speicherplatz mehr vorhanden.\n" +
		 		"Anwender ist betrunken.\n";
	}
}
