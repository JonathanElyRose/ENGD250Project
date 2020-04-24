import java.io.*; 
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImportDialog {
	private File[] selectedImages;

	public ImportDialog() {
		// create an object of JFileChooser class 
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

        // allow multiple file selection 
        j.setMultiSelectionEnabled(true); 

        // invoke the showsOpenDialog function to show the save dialog 
        int r = j.showOpenDialog(null); 

        if (r == JFileChooser.APPROVE_OPTION) { 
            // get the selected files 
            selectedImages = j.getSelectedFiles();
        }
        else {
        	selectedImages = null;
        }
	}
	
	public File[] getSelectedImages() {
		return this.selectedImages;
	}

}
