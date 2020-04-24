import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectManager {
	private HashMap<String, Project> projectMap = new HashMap<String, Project>();

	public ProjectManager() {
		mapProjects();
	}
	public void mapProjects() {
		List<String> projectFiles = new ArrayList<String>();
		File dir = new File("src/projects");
		if(dir.listFiles() != null) {
			for(File file : dir.listFiles()) {
				if(file.getName().endsWith(".proj")) {
					makeProjectInstance(file);
				}
			}
		}
	}
	
	public void makeProjectFile(Project project) {
		String fileName = project.getName().replaceAll(" ", "_");
		try {
			File projectFile = new File("src/projects/" + fileName + ".proj");
			if (projectFile.createNewFile()) {
				try {
					FileWriter fileWriter = new FileWriter(projectFile.getPath());
					PrintWriter writer = new PrintWriter(fileWriter);
					writer.print("name:" + project.getName());
					writer.print("date:" + project.getDate());
					writer.print("thumbnailPath:" + project.getThumbnailPath());
					for(String id : project.getImagesMap().keySet()) {
						writer.print("image:" + id + ":" +  project.getImagePath(id));
					}
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
	
	public void makeProjectInstance(File file) {
		Project project = new Project(file.getPath());
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file.getPath()));
			String currentLine = reader.readLine();
			while(currentLine != null) {
				handleTag(project, currentLine);
				currentLine = reader.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		projectMap.put(project.getName(), project);
	}
	
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
