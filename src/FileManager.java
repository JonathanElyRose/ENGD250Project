import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

public class FileManager  {

	public FileManager() throws IOException {
		checkForDirectory();
	}
	
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
