import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class shaap extends JFrame {

	Image image;
	Graphics graphics;

	int dotX[] = new int[1000];
	int dotY[] = new int[1000];
	Random rand = new Random();
	int otraPt[] = new int[1000];
	int speedX=1;
	int speedY=1;

	public shaap() {
		super();
	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		paintComponent(graphics);
		g.drawImage(image, 0, 0, null);
		repaint();

	}

	public void paintComponent(Graphics g) {
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
		int mouseX = MouseInfo.getPointerInfo().getLocation().x;
		
		for(int d=0; d<1000; d++) {
			
			if((dotX[d]==0) && (d!=47)) {
				dotX[d]=rand.nextInt(400)+50;
				dotY[d]=rand.nextInt(400)+50;
				otraPt[d]=rand.nextInt(999);
			}
			dotX[47]=mouseX;
			dotY[47]=mouseY;
			//g.fillOval(dotX[d], dotY[d], 10, 10);
			if((d>0) && (d<999)) {
				g.drawLine(dotX[d-1], dotY[d-1], dotX[d], dotY[d]);
				g.drawLine(dotX[d+1], dotY[d+1], dotX[d], dotY[d]);
				//g.drawLine(dotX[otraPt[d]], dotY[otraPt[d]], dotX[d], dotY[d]);
				g.drawLine(dotX[999-d], dotY[999-d], dotX[d], dotY[d]);
				
			} else if(d==0) {
				g.drawLine(dotX[d+1], dotY[d+1], dotX[d], dotY[d]);
				g.drawLine(dotX[999], dotY[999], dotX[d], dotY[d]);
				//g.drawLine(dotX[otraPt[d]], dotY[otraPt[d]], dotX[d], dotY[d]);
				g.drawLine(dotX[999-d], dotY[999-d], dotX[d], dotY[d]);
			} else if(d==999) {
				g.drawLine(dotX[d-1], dotY[d-1], dotX[d], dotY[d]);
				g.drawLine(dotX[0], dotY[0], dotX[d], dotY[d]);
				//g.drawLine(dotX[otraPt[d]], dotY[otraPt[d]], dotX[d], dotY[d]);
				g.drawLine(dotX[999-d], dotY[999-d], dotX[d], dotY[d]);
			}

			//((dotX[d-1]+dotX[d+1])/2)
			//((dotY[d-1]+dotY[d+1])/2)

			//0+(getWidth()-dotX[999-d])
			//0+(getHeight()-dotY[999-d])

			//Movement
			if((d>0) && (d<999)) {
				

				if(dotX[d]< 0+(getWidth()-dotX[999-d]) ) {
					dotX[d]=dotX[d]+2;	
				}
				if(dotX[d]> 0+(getWidth()-dotX[999-d]) ) {
					dotX[d]=dotX[d]-2;	
				}

				if(dotY[d]< 0+(getHeight()-dotY[999-d]) ) {
					dotY[d]=dotY[d]+2;	
				}
				if(dotY[d]> 0+(getHeight()-dotY[999-d]) ) {
					dotY[d]=dotY[d]-2;	
				}

				/////////////////////////////////////////////

				if(dotX[d]<= ((dotX[d-1]+dotX[d+1])/2) ) {
					dotX[d]++;
				}
				if(dotX[d]>= ((dotX[d-1]+dotX[d+1])/2) ) {
					dotX[d]--;
				}
		
				if(dotY[d]<= ((dotY[d-1]+dotY[d+1])/2) ) {
					dotY[d]++;
				}
				if(dotY[d]>= ((dotY[d-1]+dotY[d+1])/2) ) {
					dotY[d]--;
				}

				
			} else {
				if(dotX[d]< 0+(getWidth()-dotX[999-d]) ) {
					dotX[d]=dotX[d]+2;	
				}
				if(dotX[d]> 0+(getWidth()-dotX[999-d]) ) {
					dotX[d]=dotX[d]-2;	
				}

				if(dotY[d]< 0+(getHeight()-dotY[999-d]) ) {
					dotY[d]=dotY[d]+2;	
				}
				if(dotY[d]> 0+(getHeight()-dotY[999-d]) ) {
					dotY[d]=dotY[d]-2;	
				}
				
			}

			if(d==48) {
				//dotX[d]=dotX[d]+speedX;
				//dotY[d]=dotY[d]+speedY;
				if((dotX[d]>getWidth()) || (dotX[d]==1)) {
					speedX=speedX*-1;
				}
				if((dotY[d]>getHeight()) || (dotY[d]<0)) {
					speedY=speedY*-1;
				}
			}

		}
	
	}

	public static void main(String args[]) {
		shaap shape = new shaap();
		shape.setVisible(true);
		shape.setSize(500, 500);

	}


}