import java.awt.*;

public class JapanFlag implements Drawable {

    public void draw(int x, int y, int width, int height, Graphics g) {

        g.setColor(Color.white);
        g.fillRect(x,y,width,height);
        g.setColor(Color.RED);

        int radius = width/3;

        int center_x = x + width/2 - radius/2;
        int center_y = y + height/2 - radius/2;

        g.fillOval(center_x,center_y,radius,radius);

    }
}