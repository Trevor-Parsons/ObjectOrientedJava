package proj5EC;

import java.io.*;
import java.util.*;

public class ECdecryption {

	public static void main(String[] args) throws IOException {
		
		// Variable Declaration
		int foundCommonWord = 0;
		int numFilesFound = 0;
		String userFileName;
		String commonWord = "";
		byte encryptAmount = -128;
		
		Scanner input = new Scanner(System.in);
		
		// User input for byte encryption size and file name
		System.out.print("Enter the name of the file to try to decrypt: ");
		userFileName = input.nextLine().trim();
		
		// While loop to test file for possible decryption keys
		while (true)
		{
			// Open user file and add to byte array
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
			
			// Add value of encryptAmount to byte array contents
			for (int i = 0; i < userFile.length(); i++)
			{
				fileData[i] = (byte)(fileData[i] - encryptAmount);
			}
			
			// Output byte array contents to new file
			FileOutputStream output = new FileOutputStream(userFileName + ".decrypted");
			output.write(fileData);
			output.close(); 
			
			// Open new file
			BufferedReader inFile = new BufferedReader(new FileReader(userFileName + ".decrypted"));
					
			// Check file for common english words
			while ((commonWord = inFile.readLine()) != null)
			{	
				if (commonWord.contains(" the "))
					foundCommonWord++;
				if (commonWord.contains(" be "))
					foundCommonWord++;
				if (commonWord.contains(" and "))
					foundCommonWord++;
				if (commonWord.contains(" that "))
					foundCommonWord++;
				if (commonWord.contains(" to "))
					foundCommonWord++;
				if (commonWord.contains(" have "))
					foundCommonWord++;
				if (commonWord.contains(" for "))
					foundCommonWord++;
				if (commonWord.contains(" it "))
					foundCommonWord++;
				if (commonWord.contains(" with "))
					foundCommonWord++;
				if (commonWord.contains(" of "))
					foundCommonWord++;
			}
			
			inFile.close();
			
			// if a common word is found, print the possible encryption key and save the file under a new name
			if (foundCommonWord > 1)
			{
				numFilesFound++;
				System.out.println("\nPossible key found: " + encryptAmount + " bytes offset" +
									"\nCheck " + userFileName + ".decrypted" + numFilesFound + 
									" for possible decryption.");
				
				// Output byte array with possible key changes to file
				FileOutputStream decryptOut = new FileOutputStream(userFileName + ".decrypted" + numFilesFound);
				decryptOut.write(fileData);
				decryptOut.close(); 
			}
			
			foundCommonWord = 0;
			
			// While loop terminator 
			if (encryptAmount == 127)
			{
				if (numFilesFound == 0)
				{
					System.out.println("Encryption key was not found! Ending program.");
					break;
				}
				else 
					break;
			}
			
			encryptAmount++;
		}
		
		File deleteFile = new File(userFileName + ".decrypted");
		deleteFile.delete();
			
		input.close();
	}

}
