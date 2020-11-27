package javaActivity_4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class activity4_2 {

	public static void main(String[] args) throws IOException {
		try {
		
		File file = new File("C://SDET/newFile.txt");
        boolean fStatus = file.createNewFile();
        if(fStatus) {
            System.out.println("File created successfully!");
        } else {
            System.out.println("File already exists at this path.");
        }

        //get the file Object
        File fileUtil = FileUtils.getFile("C://SDET/newFile.txt");
      
        //Read file
        System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

        //Create directory
        File destDir = new File("C://SDET/newfolder");
        //Copy file to directory
        FileUtils.copyFileToDirectory(file, destDir);

        //Get file from new directory
        File newFile = FileUtils.getFile(destDir, "newfile.txt");
        //Read data from file
        String newFileData = FileUtils.readFileToString(newFile, "UTF8");
        //Print it
        System.out.println("Data in new file: " + newFileData);
    } catch(IOException errMessage) {
        System.out.println(errMessage);
    }
		
		
		
	}
}