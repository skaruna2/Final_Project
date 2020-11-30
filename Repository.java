import java.util.Observable;

import java.util.ArrayList;

public class Repository extends Observable {
   private ArrayList<ArrayList<String>> fullTableData;
   private ArrayList<ArrayList<String>> studentCoreData;

   Repository() {
       fullTableData = null;
       studentCoreData = null;
   }
   Repository(ArrayList<ArrayList<String>> data) {
       fullTableData = data;
       studentCoreData = data;
   }
   ArrayList<ArrayList<String>> removeDuplicate(ArrayList<ArrayList<String>> attendanceData) {
       ArrayList<ArrayList<String>> out = new ArrayList<>();
       boolean duplicate = false;
        for(int i = 0; i < attendanceData.size(); i++, duplicate = false) {
            for(int j =0; j < attendanceData.size(); j++) {
                if(attendanceData.get(i).get(0).equals(attendanceData.get(j).get(0))) {
                    int sum = Integer.parseInt(attendanceData.get(i).get(1)) +
                            Integer.parseInt(attendanceData.get(j).get(1));
                    attendanceData.get(i).set(1, String.valueOf(sum));
                    duplicate = true;
                }
            }
            if(!duplicate) {
                out.add(attendanceData.get(i));
            }
        }
        return out;
   }
   void setFullTableData(ArrayList<ArrayList<String>> data) {

   }


}
