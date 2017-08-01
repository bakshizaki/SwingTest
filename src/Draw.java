import java.awt.*;

import javax.swing.*;

public class Draw extends JPanel {
	private static int x,y;
	public void drawing(int xx,int yy){
		x=xx;
		y=yy;
		repaint();
		System.out.println("Indrawing   Xcord:   "+x+ "  Ycord:  "+ y);
	}
	
	public void paintComponent(Graphics g){
		System.out.println("Indrawingpaint   Xcord:   "+x+ "  Ycord:  "+ y);
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(x, y, 10, 10);
		//System.out.println("Indrawingpaint   Xcord:   "+x+ "  Ycord:  "+ y);
	}

}
