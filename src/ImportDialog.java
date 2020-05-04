import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 * This dialog is shown to allow the user to select files from their system using the JFileChooser. It can return any
 * selected files.
 * 
 * @author Jonathan Ely
 */

public class ImportDialog {
	private File[] selectedImages;

	public ImportDialog() {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
        j.setMultiSelectionEnabled(true); 
 
        int r = j.showOpenDialog(null); 

        if (r == JFileChooser.APPROVE_OPTION) { 
            selectedImages = j.getSelectedFiles();
            
            for(File file : selectedImages) {
	            try {
	            	BufferedImage image = ImageIO.read(file);
	            	File output = new File(System.getProperty("user.dir") + "/src/data/images/" + file.getName());
	            	String extension = file.getName().substring(file.getName().lastIndexOf('.') + 1);
	            	ImageIO.write(image, extension, output);
	            } 
	            catch(IOException e) {
	            	System.out.println("Write error for " + file.getPath() + ": " + e.getMessage());
	            }
            }
        }
        else {
        	selectedImages = null;
        }
	}
	
	public File[] getSelectedImages() {
		return this.selectedImages;
	}

}
