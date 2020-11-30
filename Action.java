import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Action implements ActionListener {
    private World world;
    private Repository repo;
    Action(World world) {
        this.world = world;
        this.repo = new Repository();
        repo.addObserver(world);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        // if About Button is pressed, prints dialog box
        if (e.getActionCommand().equals(e.getSource())) {
            JOptionPane.showMessageDialog(world, "CSE 360 Final Project done by:"
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
                world.table = new Table(data, column);
                world.table.getJT().setBounds(30, 40, 200, 300);
                JScrollPane sp = new JScrollPane(world.table.getJT());
                world.add(sp);

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
                ArrayList<String[]> dialog = world.table.addColumn(data, test);
                String dialogLine = dialogLine(dialog);
                JOptionPane.showMessageDialog(world, "Data loaded for " + dialog.get(dialog.size() - 1)[0]
                        + " users in the roster.\n" + (dialog.size() - 2) + dialogLine);

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        world.revalidate();
        world.repaint();
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
}
