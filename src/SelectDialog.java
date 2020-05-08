import javax.swing.JFileChooser;

public class SelectDialog {
	private String[] selectedImages;

	public SelectDialog() {
        JFileChooser j = new JFileChooser(System.getProperty("user.dir") + "/src/data/images/"); 
        j.setMultiSelectionEnabled(true); 
 
        int r = j.showOpenDialog(null); 

        if (r == JFileChooser.APPROVE_OPTION) {
        	
        	selectedImages = new String[j.getSelectedFiles().length];
            
            for(int i = 0; i < selectedImages.length; i++) {
	            selectedImages[i] = j.getSelectedFiles()[i].getPath();
            }
        }
        else {
        	selectedImages = null;
        }
	}
	
	public String[] getSelectedImages() {
		return this.selectedImages;
	}

}
