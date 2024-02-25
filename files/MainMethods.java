package files;

import java.io.File; // Import the File class

public class MainMethods {
  public static void main(String[] args) {

    File myObj = new File("filename.txt"); // Specify the filename
    System.out.println(myObj.exists());

    // canRead()	Boolean	Tests whether the file is readable or not
    // canWrite()	Boolean	Tests whether the file is writable or not
    // createNewFile()	Boolean	Creates an empty file
    // delete()	Boolean	Deletes a file
    // exists()	Boolean	Tests whether the file exists
    // getName()	String	Returns the name of the file
    // getAbsolutePath()	String	Returns the absolute pathname of the file
    // length()	Long	Returns the size of the file in bytes
    // list()	String[]	Returns an array of the files in the directory
    // mkdir()	Boolean	Creates a directory
  }
}
