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
	private int numOfProjects;

	public ProjectManager() {
		this.numOfProjects = 0;
		mapProjects();
	}
	
	/**
	 * Searches through the /projects directory and reads any .proj files using the makeProjectInstance method
	 */
	public void mapProjects() {
		File dir = new File("src/data/projects");
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
	public String makeProjectFile(Project project) {
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
					writer.close();
					fileWriter.close();
					
					String[] paths = new String[project.getImagesMap().size()];
					for(int i = 0; i < project.getImagesMap().size(); i++) {
						paths[i] = project.getImagesMap().get(i);
					}
					addImages(paths, project, projectFile.getPath(), "new file");
					
					return "";
				}
				catch(IOException e) {
					System.out.println("Warning in ProjectManager: Could not write to .proj file '" + fileName + "'. Project file assumed to be empty or corrupted");
					return "";
				}
				
			}
			else {
				System.out.println("Warning in ProjectManager: .proj file '" + fileName + "' already exists");
				return "exists";
			}
		}
		catch (IOException e) {
			System.out.println("Fatal Error in ProjectManager: Unable to create .proj file '" + fileName + "'");
			e.printStackTrace();
			return "";
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
		
		addProject(project);
		
		if(project.getImagesMap().keySet().size() == 0) {
			project.setThumbnailPath(null);
		}
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
			String[] tagIdAndPath = currentLine.split(":", 3);
			project.addImage(Integer.parseInt(tagIdAndPath[1]), tagIdAndPath[2]);
		}
		else {
			System.out.println("Error in ProjectManager: .proj file at '" + project.getFilePath() + "' has unreadable line '" + currentLine + "'. File was called from: " + Thread.currentThread().getStackTrace()[2].getClassName());
		}
	}
	
	/**
	 * A getter method for the number of projects in the projectMap
	 * 
	 * @return int numOfProjects - The size of the projectMap
	 */
	public int getNumOfProjects() {
		return this.numOfProjects;
	}
	
	/**
	 * A getter method for the HashMap projectMap, giving access to all known projects
	 * 
	 * @return HashMap<String,Project> projectMap - A HashMap of all known projects
	 */
	public HashMap<String, Project> getProjectMap() {
		return this.projectMap;
	}
	
	/**
	 * A method which adds a Project instance to the projectMap
	 * 
	 * @param project - The Project to be added to the projectMap
	 */
	public void addProject(Project project) {
		projectMap.put(project.getName(), project);
		this.numOfProjects++;
	}
	
	/**
	 * A method for adding images to new or existing projects. Both writes to their .proj file and adds it to the Project's imagesMap
	 * 
	 * @param paths - A String array of paths to images in src/data/images. Method will do nothing if array is null.
	 * @param project - The project to which images are being added.
	 */
	public void addImages(String[] paths, Project project, String projectPath, String mode) {
		if(paths != null) {
			int numOfImages = 0;
			if(mode.equals("existing file")) {
				if(project.getImagesMap().size() > 0) {
					numOfImages = project.getImagesMap().size();
				}
			}
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(projectPath, true);
				PrintWriter writer = new PrintWriter(fileWriter);
				for(int i = 0; i < paths.length; i++) {
					project.addImage(i + numOfImages, paths[i]);
					writer.println("image:" + Integer.toString(i + numOfImages) + ":" +  paths[i]);
				}
				
				writer.close();
				fileWriter.close();
				
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
