import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Action implements ActionListener {
    private World world;
    private Repo repo;
    Action(World world, Repo repo) {
        this.world = world;
        this.repo = repo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "About") {

        }
        if(e.getActionCommand() == "Load a Roster") {
            JFileChooser chooser = new JFileChooser();
            Reader reader = new Reader();
            chooser.showOpenDialog(null);
            try {
                String[][] data = reader.readRoster(chooser.getSelectedFile());
                repo.setData(data);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        if(e.getActionCommand() == "Add Attendance") {
            JFileChooser chooser = new JFileChooser();
            Reader reader = new Reader();
            chooser.showOpenDialog(null);
            try {
                ArrayList<String[]> dialog = repo.addColumn(reader.readAttendance(chooser.getSelectedFile()), "NOV^^^");
                String dialogLine = dialogLine(dialog);
                JOptionPane.showMessageDialog(world, "Data loaded for " + dialog.get(dialog.size() - 1)[0]
                        + " users in the roster.\n" + (dialog.size() - 1) + dialogLine);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        if(e.getActionCommand() == "Save") {
            System.out.println("4");
        }
        if(e.getActionCommand() == "Plot Data") {
            System.out.println("5");
        }
    }
    String dialogLine(ArrayList<String[]> dialog) {
        String dialogLine, plural;
        if (dialog.size() - 1 == 1) {
            dialogLine = " additional attendee was found: \n";
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

