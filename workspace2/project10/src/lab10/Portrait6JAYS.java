package lab10;
import java.awt.Color;
import java.awt.Graphics;


public class Portrait6JAYS extends Portrait {
	public Portrait6JAYS() {
		super(.2);
		setBodyHeight(.3);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.ORANGE);

		int midX = getWidth() /2;

		//draws a tail
		int tailRadius = headRadius;
		g.drawArc(midX-9, (int) (bodyHeight*1.5), tailRadius * 2,
				tailRadius * 2, 45, -180);
		
		 //draws two eyes
	    int eyeRadius = (int)(0.04 * SIZE);
	    g.fillOval((int)(midX*.8) - eyeRadius, headRadius - eyeRadius * 2, 2 * eyeRadius,
	        2 * eyeRadius);
	    g.fillOval(midX + eyeRadius, headRadius - eyeRadius * 2, 2 * eyeRadius,
	        2 * eyeRadius);
	    

	}
}
