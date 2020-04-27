import java.io.File;
import java.io.IOException;

/**
 * This class checks that the directories the program requires are available, and if not, creates them. Without these directories, the program
 * won't be able to access necessary files, and throws fatal errors.
 * 
 * @author Jonathan Ely
 */
public class FileManager  {

	public FileManager() throws IOException {
		checkForDirectory();
	}
	
	/**
	 * Goes through the directories from the top down, checking for each. If they don't exist, it makes them. If it is unable to
	 * complete any of the directory creations, it throws a fatal error.
	 * 
	 * @throws IOException
	 */
	public void checkForDirectory() throws IOException {
		File data = new File("src/data");
		File images = new File("src/data/images");
		File projects = new File("src/data/projects");
		
		if(!data.exists()) {
			if(!data.mkdir()) {
				System.out.println("Fatal Error in FileManager: Directory at " + data.getPath() + " could not be created");
				throw new IOException();
			}
		}
		if(!images.exists()) {
			if(!images.mkdir()) {
				System.out.println("Fatal Error in FileManager: Directory at " + images.getPath() + " could not be created");
				throw new IOException();
			}
		}
		if(!projects.exists()) {
			if(!projects.mkdir()) {
				System.out.println("Fatal Error in FileManager: Directory at " + projects.getPath() + " could not be created");
				throw new IOException();
			}
		}
	}
}
