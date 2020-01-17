package Decrypt;

import java.util.*;
import java.io.*;

public class Decryption {

	public static void main(String[] args) throws IOException {
		
		// Variable Declaration
		String userFileName;
		byte decryptAmount;
		
		Scanner input = new Scanner(System.in);
		
		// User input for byte encryption size and file name
		System.out.print("Enter the byte size for decryption (-128 to 127): ");
		decryptAmount =  input.nextByte();
		input.nextLine();
		
		System.out.print("\nEnter the name of the file to decrypt: ");
		userFileName = input.nextLine().trim();
		
		// Open and read binary file into byte array
		File userFile = new File (userFileName);
		byte fileData[] = new byte[(int) userFile.length()];
		
		try (FileInputStream fileInput = new FileInputStream(userFileName))
		{
			fileInput.read(fileData);
		}
		catch (FileNotFoundException e) {
			System.out.println("Could not find file" + e);
		}
		catch (IOException ioe)
		{
			System.out.println("Problem reading file " + ioe);
		}
		
		// Decrypt the file using the provided key and output to .decrypted file
		for (int i = 0; i < userFile.length(); i++)
		{
			fileData[i] = (byte)(fileData[i] - decryptAmount);
		}
		
		FileOutputStream output = new FileOutputStream(userFileName + ".decrypted");
		output.write(fileData);
		output.close(); 
		
		System.out.println("\nThe file has been decrypted, down with the lizard people!");
		
		input.close();
	}
}
