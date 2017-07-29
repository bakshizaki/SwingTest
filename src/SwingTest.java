import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

public class SwingTest {
	
	static JMenuBar mb;    
	static JMenu file, fbd, help;    
	static JMenuItem open, exit, selectFBD, about;
	static JLabel lImage;

	public static void main(String[] args) {
		JFrame f = new JFrame("eGuru");
		
		open=new JMenuItem("Open File");    
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();    
			    int i=fc.showOpenDialog(f);    
			    if(i==JFileChooser.APPROVE_OPTION){    
			    	 File f=fc.getSelectedFile();    
			         String filepath=f.getPath();    
			         BufferedImage img = null;
					try {
						img = ImageIO.read(new File(filepath));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						img = imageResizing(img, 760, 400);
			         lImage.setIcon(new ImageIcon(img));
			    }
				
			}
		});        
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		selectFBD = new JMenuItem("Select FBD");
		about = new JMenuItem("About");
		
		file=new JMenu("File"); 
		file.add(open);
		file.add(exit);
		
		fbd = new JMenu("FBD");
		fbd.add(selectFBD);
		
		help = new JMenu("Help");
		help.add(about);
		             
		mb=new JMenuBar();    
		mb.setBounds(0,0,800,20);   
		mb.add(file); mb.add(fbd); mb.add(help);
		
		lImage = new JLabel();
		lImage.setBounds(20,0,780,480);
		lImage.setText("Open an image");
		lImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lcoordinates = new JLabel();
//		lcoordinates.setLocation(480, 520);
		lcoordinates.setBounds(350, 480, 100, 20);
		lcoordinates.setText("Coordinates: ");
		
		f.add(mb);
		f.add(lImage);
		f.add(lcoordinates);
		f.setSize(800, 550);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static BufferedImage imageResizing(BufferedImage img, int width, int height) {
		BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bimg.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(img, 0, 0, width, height, null);
		g2d.dispose();
		return bimg;
	}
	
}
