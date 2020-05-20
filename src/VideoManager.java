import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import com.xuggle.mediatool.IMediaListener;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.mediatool.event.IAddStreamEvent;
import com.xuggle.mediatool.event.IAudioSamplesEvent;
import com.xuggle.mediatool.event.ICloseCoderEvent;
import com.xuggle.mediatool.event.ICloseEvent;
import com.xuggle.mediatool.event.IFlushEvent;
import com.xuggle.mediatool.event.IOpenCoderEvent;
import com.xuggle.mediatool.event.IOpenEvent;
import com.xuggle.mediatool.event.IReadPacketEvent;
import com.xuggle.mediatool.event.IVideoPictureEvent;
import com.xuggle.mediatool.event.IWriteHeaderEvent;
import com.xuggle.mediatool.event.IWritePacketEvent;
import com.xuggle.mediatool.event.IWriteTrailerEvent;
import com.xuggle.xuggler.ICodec;

public class VideoManager {
	JProgressBar progressBar;
	JFrame frame;
	
	public VideoManager() {
	}
	
	public void exportVideo(Project project, int fps) {
		
		File dir = new File("src/data/projects");
		final IMediaWriter writer = ToolFactory.makeWriter(dir.getAbsolutePath() + "/" + project.getName() + ".mp4");
		writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_MPEG4, 720, 480);
		
		writer.addListener(new IMediaListener() {
			@Override
			public void onClose(ICloseEvent arg0) {
			}
			@Override
			public void onAddStream(IAddStreamEvent arg0) {				
			}
			@Override
			public void onAudioSamples(IAudioSamplesEvent arg0) {	
			}
			@Override
			public void onCloseCoder(ICloseCoderEvent arg0) {
				progressBar.setValue(100);
				frame.setTitle("Completed!");
			}
			@Override
			public void onFlush(IFlushEvent arg0) {
			}
			@Override
			public void onOpen(IOpenEvent arg0) {
			}
			@Override
			public void onOpenCoder(IOpenCoderEvent arg0) {
			}
			@Override
			public void onReadPacket(IReadPacketEvent arg0) {
			}
			@Override
			public void onVideoPicture(IVideoPictureEvent arg0) {
			}
			@Override
			public void onWriteHeader(IWriteHeaderEvent arg0) {
			}

			@Override
			public void onWritePacket(IWritePacketEvent arg0) {
			}
			@Override
			public void onWriteTrailer(IWriteTrailerEvent arg0) {
			}
		});
		
		long startTime = System.nanoTime();
		
		SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
			
			@Override
			protected Boolean doInBackground() throws Exception {
				for(int i = 0; i < project.getImagesMap().size(); i++) {
					try {
						BufferedImage currentImage = ImageIO.read(new File(project.getImagePath(i)));
						BufferedImage convertedImage;
						convertedImage = new BufferedImage(720, 480, BufferedImage.TYPE_3BYTE_BGR);
						convertedImage.getGraphics().drawImage(currentImage, 0, 0, null);
						writer.encodeVideo(0,  convertedImage, System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
						
						progressBar.setValue((i * 100) / (project.getImagesMap().size()));
						
						Thread.sleep(1000 / fps);
					} 
					catch (IOException e) {
						e.printStackTrace();
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				writer.close();
				return true;
			}
			
		};
		worker.execute();
	}
	public void makeProgressBar() {
		frame = new JFrame("Exporting...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField text = new JTextField();
        text.setEditable(false);
        text.setText("Progresss:");
		
		progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
		
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.add(text);
        panel.add(progressBar);
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
	}
}
