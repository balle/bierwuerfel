package de.bierwuerfel.dao.bier;

/*
 * Bierwuerfel! - Weil Chaos Spass macht :)
 *
 * Diese Klasse kuemmert sich um die Persistenz des Bieres
 * oder mit ohne Buzzwords: Das hier ist der Bierdeckel.
 * Gespeichert wird via holprig zu benutzenden RecordStore
 *
 * @author Bastian Ballmann
 * {@link http://www.datenterrorist.de}
 */

import de.bierwuerfel.*;

import java.io.*;

import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class BierDAORecordStore implements BierDAOInterface
{
	RecordStore db;

	/*
	 * Constructor
	 */
	public BierDAORecordStore(String file) throws Throwable
	{
		db = RecordStore.openRecordStore(file, true);
	}

	
	/*
	 * Save a beer 
	 * @param bier
	 */
	public int set(Bier bier) throws Throwable
	{
		ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(bytesOut);

		dataOut.writeInt(bier.getNumber());
		byte[] data = bytesOut.toByteArray();
		dataOut.close();

		return db.addRecord(data, 0, data.length);
	}

	
	/*
	 * Delete all beer
	 */
	public void format() throws Throwable
	{
		RecordEnumeration re = db.enumerateRecords(null, null, false);

		while(re.hasNextElement())
		{
			db.deleteRecord( re.nextRecordId() );
		}
	}

	
	/*
	 * Retrieve all beer
	 * @return array of beer objects
	 */
	public Bier[] get() throws InvalidRecordIDException, RecordStoreException, IOException
	{
		RecordEnumeration re = db.enumerateRecords(null, null, false);
		Bier[] liste = new Bier[re.numRecords()];
		int i = 0;

		while(re.hasNextElement())
		{
			byte[] record = re.nextRecord();

			ByteArrayInputStream bytesIn = new ByteArrayInputStream(record);
			DataInputStream dataIn = new DataInputStream(bytesIn);

			int nr = dataIn.readInt();
			liste[i] = new Bier(nr);
			i++;
		}

		return liste;
	}

	
	/*
	 * Delete a beer by its number
	 * @param integer
	 */
	public int del(int nr) throws Throwable
	{
		RecordEnumeration re = db.enumerateRecords(null, null, false);
		int deleted = 0;

		while(re.hasNextElement())
		{
			int id = re.nextRecordId();
			byte[] record = db.getRecord(id);

			ByteArrayInputStream bytesIn = new ByteArrayInputStream(record);
			DataInputStream dataIn = new DataInputStream(bytesIn);

			if(dataIn.readInt() == nr)
			{
				db.deleteRecord(id);
				deleted++;
			}
		}

		return deleted;
	}
}