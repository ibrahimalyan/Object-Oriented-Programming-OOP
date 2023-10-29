import java.awt.*;

public class GermanyFlag implements Drawable {

    public  void draw(int x, int y, int width, int height, Graphics g) {

        int rect_height = height / 3;

        g.setColor(Color.black);
        g.fillRect(x,y,width,rect_height);

        g.setColor(Color.red);
        g.fillRect(x,y + rect_height,width,rect_height);

        g.setColor(Color.yellow);
        g.fillRect(x,y + rect_height * 2,width,rect_height);
    }
}