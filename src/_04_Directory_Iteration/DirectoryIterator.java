package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {

	
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
//		JFileChooser jfc = new JFileChooser();
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//		int returnVal = jfc.showOpenDialog(null);
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//			File directory = jfc.getSelectedFile();
//			File[] files = directory.listFiles();
//			if(files != null) {
//				for(File f : files) {
//				  //writeToFile(f.getAbsolutePath());
//				  System.out.println(f.getAbsolutePath());
//				}
//			}
//		}
		
		File src = new File("src");
		File[] files = src.listFiles();
		
		if (files != null) {
			for (File f : files) {
				File[] subFiles = f.listFiles();
				if (subFiles != null) {
					for (File subFile : subFiles) {
						String fileName = subFile.getAbsolutePath();
						if (fileName.substring(fileName.length()-5, fileName.length()).equals(".java")) {
							try {
								FileWriter fw = new FileWriter(fileName, true);
								fw.write("\n\n//Copyright © 2019 Athena Hernández");
								fw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
		
	}
}


//Copyright © 2019 Athena Hernández