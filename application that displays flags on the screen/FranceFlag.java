import java.awt.*;

public class FranceFlag implements Drawable {

    public void draw(int x, int y, int width, int height, Graphics g) {


        int rect_width = width / 3;

        g.setColor(Color.blue);
        g.fillRect(x,y,rect_width,height);

        g.setColor(Color.white);
        g.fillRect(x + rect_width,y,rect_width,height);

        g.setColor(Color.red);
        g.fillRect(x + 2*rect_width,y,rect_width,height);

    }
}