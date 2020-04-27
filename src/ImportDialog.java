import java.io.*; 
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
        }
        else {
        	selectedImages = null;
        }
	}
	
	public File[] getSelectedImages() {
		return this.selectedImages;
	}

}
