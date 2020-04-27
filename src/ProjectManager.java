import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * This class offers methods for reading pre-existing .proj files at startup, turning them into Project instances, and also the
 * creation of .proj files and Project instances. Anything Project related will pass through here.
 * 
 * @author Jonathan Ely.
 */

public class ProjectManager {
	private HashMap<String, Project> projectMap = new HashMap<String, Project>();

	public ProjectManager() {
		mapProjects();
	}
	
	/**
	 * Searches through the /projects directory and reads any .proj files using the makeProjectInstance method
	 */
	public void mapProjects() {
		File dir = new File("src/projects");
		if(dir.listFiles() != null) {
			for(File file : dir.listFiles()) {
				if(file.getName().endsWith(".proj")) {
					makeProjectInstance(file);
				}
			}
		}
	}
	
	/**
	 * Given a Project class with it's project specific attributes, this method turns that information into a .proj file in the
	 * right format. It throws a fatal error if the file can't be created or written to, and a warning if the project already
	 * exists
	 * 
	 * @param project
	 */
	public void makeProjectFile(Project project) {
		String fileName = project.getName().replaceAll(" ", "_");
		try {
			File projectFile = new File(System.getProperty("user.dir") + "/src/data/projects/" + fileName + ".proj");
			if (projectFile.createNewFile()) {
				try {
					FileWriter fileWriter = new FileWriter(projectFile.getPath());
					PrintWriter writer = new PrintWriter(fileWriter);
					writer.println("name:" + project.getName());
					writer.println("date:" + project.getDate());
					writer.println("thumbnailPath:" + project.getThumbnailPath());
					for(String id : project.getImagesMap().keySet()) {
						writer.println("image:" + id + ":" +  project.getImagePath(id));
					}
					writer.close();
					fileWriter.close();
				}
				catch(IOException e) {
					System.out.println("Warning in ProjectManager: Could not write to .proj file '" + fileName + "'. Project file assumed to be empty or corrupted");
				}
				
			}
			else {
				System.out.println("Warning in ProjectManager: .proj file '" + fileName + "' already exists");
			}
		}
		catch (IOException e) {
			System.out.println("Fatal Error in ProjectManager: Unable to create .proj file '" + fileName + "'");
			e.printStackTrace();
		}
	}
	
	/**
	 * Takes in .proj file and reads for specified lines using the handleTag method. Takes each of these attributes, sets them to
	 * fields in a Project instance, and adds the Project to the projectMap
	 * 
	 * @param file - File instance which is expected to be a .proj file
	 */
	public void makeProjectInstance(File file) {
		Project project = new Project();
		project.setFilePath(file.getPath());
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file.getPath()));
			String currentLine = reader.readLine();
			while(currentLine != null) {
				handleTag(project, currentLine);
				currentLine = reader.readLine();
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		projectMap.put(project.getName(), project);
		
	}
	
	/**
	 * Reads a line for a specified tag, and if there is information on that line, adds it to the provided Project instance. Prints
	 * an error is a line is unreadable
	 *
	 * @param project - The Project instance to add any data to
	 * @param currentLine - A String of the current line being read in a .proj file
	 */
	public void handleTag(Project project, String currentLine) {
		if(currentLine.contains("name:")) {
			project.setName(currentLine.substring(5));
		}
		else if(currentLine.contains("date:")) {
			project.setDate(currentLine.substring(5));
		}
		else if(currentLine.contains("thumbnailPath:")) {
			project.setThumbnailPath(currentLine.substring(("thumbnailPath:").length()));
		}
		else if(currentLine.contains("image:")) {
			String[] tagIdAndPath = currentLine.split(":");
			project.addImage(tagIdAndPath[1], tagIdAndPath[2]);
		}
		else {
			System.out.println("Error in ProjectManager: .proj file at '" + project.getFilePath() + "' has unreadable line '" + currentLine + "'. File was called from: " + Thread.currentThread().getStackTrace()[2].getClassName());
		}
	}

}
