import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;
import java.util.Observer;


public class Table implements Observer {
    DefaultTableModel model;
    JTable jt;

    Table(String[][] data, String column[]) {
        model = new DefaultTableModel();
        jt = new JTable(model);
        for (int i = 0; i < column.length; i++) {
            model.addColumn(column[i]);
        }
        for (int i = 0; i < data.length; i++) {
            model.addRow(data[i]);
        }
    }

    JTable getJT() {
        return jt;
    }

    ArrayList<String[]> addColumn(String data[][], String date) {
        ArrayList<String[]> notInRoster = new ArrayList<>();
        Vector tableData = model.getDataVector();
        String[] columnData = new String[model.getRowCount()];
        boolean inTable = true;
        int n = 0, k = 0;
        for (int i = 0; i < data.length; i++, inTable = true) {
            for (int j = 0; j < tableData.size(); j++) {
                if (data[i][0].equals(((Vector) tableData.elementAt(j)).elementAt(5))) {
                    columnData[j] = data[i][0];
                    inTable = false;
                    n++;
                    break;
                }
            }
            if (inTable) {
                notInRoster.add(data[i]);
            }
        }
        model.addColumn(date, columnData);
        String[] temp = {(String.valueOf(n))};
        notInRoster.add(temp);
        return notInRoster;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

