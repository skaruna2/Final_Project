
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reader {

    ArrayList<ArrayList<String>> read(File f) throws FileNotFoundException {
        ArrayList<ArrayList<String>> out = new ArrayList<>();
        Scanner fScan = new Scanner(f);
        String temp;
        while (fScan.hasNextLine()) {
            temp = fScan.nextLine();
            out.add((ArrayList<String>) Arrays.asList(temp.split(",")));
        }
        return out;
    }

    String[][] readRoster(File f) throws FileNotFoundException {
        Scanner fScan = new Scanner(f);
        String t;
        ArrayList<String[]> data = new ArrayList<String[]>();
        while (fScan.hasNextLine()) {
            t = fScan.nextLine();
            data.add(t.split(","));
        }
        String[][] out = new String[data.size()][6];
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                out[i][j] = data.get(i)[j];
                System.out.print(" | " + out[i][j]);
            }
            System.out.println();
        }
        return out;
    }

    String[][] readAttendance(File f) throws FileNotFoundException {
        Scanner fScan = new Scanner(f);
        String temp;
        String[] tempArr;
        ArrayList<String[]> data = new ArrayList<String[]>();
        while (fScan.hasNextLine()) {
            boolean add = true;
            temp = fScan.nextLine();
            tempArr = temp.split(",");
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i)[0].equals(tempArr[0])) {
                    int tempInt = Integer.parseInt(data.get(i)[1]);
                    tempInt += Integer.parseInt(tempArr[1]);
                    data.get(i)[1] = String.valueOf(tempInt);
                    add = false;
                }
            }
            if (add) {
                data.add(tempArr);
            }
        }
        String[][] out = new String[data.size()][2];
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                out[i][j] = data.get(i)[j];
            }
        }
        return out;
    }
}
