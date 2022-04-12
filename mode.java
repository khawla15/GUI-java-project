//khawla hassan Alqarni -1914906- -M-
package guiproject;
import java.awt.*;
import javax.swing.*;
public class mode extends JPanel {
    static Color c1 = new Color(95, 191, 188, 225);
    static Color c2 = new Color(83, 58, 114);


        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0, c1, 50, getHeight(), c2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.setPaint(new Color(157, 157, 189, 60)); //square transparency
            g2d.fill3DRect(50, 80, 600, 570, true);
        }
}//end mode class
