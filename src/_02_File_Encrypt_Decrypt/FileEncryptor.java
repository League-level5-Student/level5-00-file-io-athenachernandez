package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String encryptedStr = "";
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/test.txt");
			int c = fr.read();
			while (c != -1) {
				if (Character.isUpperCase(c)) {
					if ((c + 4) > 90) {
						c = c - 87 + 65;
					} else {
						c +=4;
					}
				} else if (Character.isLowerCase(c)) {
					if ((c + 4) > 122) {
						c = 122 - c + 97;
					} else {
						c +=4;
					}
				} else if ((char) c == ' ') {
					c = ' ';
				}
				encryptedStr += (char) c;
				c = fr.read();
			}
			System.out.println(encryptedStr);
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
