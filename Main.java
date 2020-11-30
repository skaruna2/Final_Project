import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] argv)  {

        Action action = new Action();
        World world = new World();

        // add menubar to frame
        this.setJMenuBar(mb);

        // set the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}