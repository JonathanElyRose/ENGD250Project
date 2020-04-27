import java.util.HashMap;

/**
 * This class is just a way to bundle together all the different data about a Project.
 * 
 * @author Jonathan Ely.
 */

public class Project {
	private String name;
	private String filePath;
	private String date;
	private String thumbnailPath;
	private HashMap<String, String> imagesMap = new HashMap<String, String>();

	/*
	 * All of the below methods are getter and setter methods for the various fields of the Project class.
	 */
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath(String id) {
		return this.imagesMap.get(id);
	}
	public void addImage(String id, String path) {
		this.imagesMap.put(id, path);
	}
	public HashMap<String, String> getImagesMap() {
		return this.imagesMap;
	}
	public void setImagesMap(HashMap<String, String> map) {
		this.imagesMap = map;
	}
}
