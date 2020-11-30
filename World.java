

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class World extends JPanel implements Observer {

    private JMenu x;
    private JButton aboutButton;
    private JMenuItem mL;

     Table table;

    public World() {
        Action action = new Action(this);
        // create a menubar
        JMenuBar mb = new JMenuBar();
        // create a menu
        x = new JMenu("File");
        aboutButton = new JButton("About");
        // create menuitems
        JMenuItem m1 = new JMenuItem("Load a Roster");
        JMenuItem m2 = new JMenuItem("Add Attendance");
        JMenuItem m3 = new JMenuItem("Save");
        JMenuItem m4 = new JMenuItem("Plot Data");
        // add menu items to menu
        x.add(m1);
        x.add(m2);
        x.add(m3);
        x.add(m4);

        aboutButton.addActionListener(action);
        m1.addActionListener(action);
        m2.addActionListener(action);
        m3.addActionListener(action);
        m4.addActionListener(action);


        // add menu to menu bar 
        mb.add(x);
        mb.add(aboutButton);
        this.setLayout(new BorderLayout());
        this.add(mb,BorderLayout.NORTH);


    }

    public void update(Observable o, String date, String[][] data) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }



    /*
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        World world = new World();

    }
    */

    /*@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        // if About Button is pressed, prints dialog box
        if (aboutButton.equals(e.getSource())) {
            JOptionPane.showMessageDialog(this, "CSE 360 Final Project done by:"
                    + "\nWilliam Bowden" + "\nKyle Otstot" + "\nShawn Karunanayake"
            );
        }

        // JMenu File Menu buttons
        if (e.getActionCommand() == "Load a Roster") {
            JFileChooser choose = new JFileChooser();
            Reader reader = new Reader();
            choose.showOpenDialog(null);
            try {
                String[][] data = reader.readRoster(choose.getSelectedFile());
                String column[] = {"ID", "First Name", "Last Name", "Program", "Academic Level", "ASURITE"};
                table = new Table(data, column);
                table.getJT().setBounds(30, 40, 200, 300);
                JScrollPane sp = new JScrollPane(table.getJT());
                this.add(sp);

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        if (e.getActionCommand() == "Add Attendance") {
            JFileChooser choose = new JFileChooser();
            Reader reader = new Reader();
            choose.showOpenDialog(null);
            try {
                String[][] data = reader.readAttendance(choose.getSelectedFile());
                //TODO date picker
                String test = "JEFF";
                ArrayList<String[]> dialog = table.addColumn(data, test);
                String dialogLine = dialogLine(dialog);
                JOptionPane.showMessageDialog(this, "Data loaded for " + dialog.get(dialog.size() - 1)[0]
                        + " users in the roster.\n" + (dialog.size() - 2) + dialogLine);

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        revalidate();
        repaint();
    }

    String dialogLine(ArrayList<String[]> dialog) {
        String dialogLine, plural;
        if (dialog.size() - 2 == 1) {
            dialogLine = " additional attendee was found: ";
        } else {
            dialogLine = " additional attendees were found:\n";
        }
        for (int i = 0; i < dialog.size() - 1; i++) {
            if (Integer.parseInt(dialog.get(i)[1]) > 1) {
                plural = " minutes\n";
            } else {
                plural = " minute\n";
            }
            dialogLine += dialog.get(i)[0] + ", connected for " + dialog.get(i)[1] + plural;
        }
        return dialogLine;
    }
*/
}