/**
 * @author Isaac Allen
 *
 */

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;

public class HandleXML {
	public static void write(ArrayList<Employee> Employees, String filename) throws Exception //XML Saving Method
	{
		XMLEncoder encoder =
				new XMLEncoder(
						new BufferedOutputStream(
								new FileOutputStream(filename)));
		encoder.writeObject(Employees);
		encoder.close();
	}
	
	public static ArrayList<Employee> read(String filename) throws Exception  //XML Loading Method
	{
		XMLDecoder decoder =
				new XMLDecoder(new BufferedInputStream(
						new FileInputStream(filename)));
		ArrayList<Employee> Employees = (ArrayList<Employee>) decoder.readObject();
		decoder.close();
		return Employees;
	}
}
