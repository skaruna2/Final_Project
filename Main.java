import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        World world = new World();

        this.add(world);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);

    }
    public static void main(String[] argv)  {
        Main m = new Main();
        // add menubar to frame
        //;

        // set the size of the frame

    }
}