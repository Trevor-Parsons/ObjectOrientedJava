package encryption;
import java.util.*;
import java.io.*;

public class Encryption {

	public static void main(String[] args) throws IOException {
		
		// Variable Declaration
		String userFileName;
		byte encryptAmount;
		
		Scanner input = new Scanner(System.in);
		
		// User input for byte encryption size and file name
		System.out.print("Enter the byte size for encyrption (-128 to 127): ");
		encryptAmount =  input.nextByte();
		input.nextLine();
		
		System.out.print("\nEnter the name of the file to encrypt: ");
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
	
		for (int i = 0; i < userFile.length(); i++)
		{
			fileData[i] = (byte)(fileData[i] + encryptAmount);
		}
		
		// Send the encrypted file to a new file with .encrypted tag
		FileOutputStream output =  new FileOutputStream(userFileName + ".encrypted");
		output.write(fileData);
		output.close(); 
		
		System.out.println("\nFile has been encrypted, down with the Lizard people!");
		
		input.close();
	}
}
