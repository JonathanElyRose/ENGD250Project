import java.io.*; 
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImportDialog {

	public ImportDialog() {
		// create an object of JFileChooser class 
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

        // allow multiple file selection 
        j.setMultiSelectionEnabled(true); 

        // invoke the showsOpenDialog function to show the save dialog 
        int r = j.showOpenDialog(null); 

        if (r == JFileChooser.APPROVE_OPTION) { 
            // get the selected files 
            File files[] = j.getSelectedFiles();
            
            System.out.println(files.length);
        }
	}

}
