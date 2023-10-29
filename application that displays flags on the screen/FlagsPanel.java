import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FlagsPanel extends JPanel{

    private Drawable[][] flags;
    private int rows;
    private int cols;

    public FlagsPanel(int rows, int cols){
        super();

        flags = new Drawable[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flags[i][j] = get_random_flag();
            }

        }

        this.rows = rows;
        this.cols = cols;


    }


    private Drawable get_random_flag(){

        Random gen = new Random();

        int n = gen.nextInt(3);

        switch (n){
            case 0: return new FranceFlag();
            case 1: return new GermanyFlag();
            case 2: return new JapanFlag();
        }
        return new JapanFlag();
    }

   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();



        int width = (int) (screenSize.getWidth() / cols);
        int height = (int) (screenSize.getHeight()/  rows);

        int y = 0;

        for (int i = 0; i < rows; i++) {

            int x = 0;
            for (int j = 0; j < cols; j++) {

                flags[i][j].draw(x,y,width,height,g);

                x += width;

            }

            y += height;

        }


    }
}
