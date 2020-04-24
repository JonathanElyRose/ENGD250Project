import java.nio.file.Path;
import java.util.HashMap;

public class Project {
	private String name;
	private String filePath;
	private String date;
	private String thumbnailPath;
	private HashMap<String, String> imagesMap = new HashMap<String, String>();

	public Project(String filePath) {
		this.filePath = filePath;
	}
	public String getFilePath() {
		return filePath;
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
}
