/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class MyTableModelListener implements TableModelListener {

    Object[][] data;

    public MyTableModelListener(Object[][] data) {
        this.data = data;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < ManagePerson.pList.size(); j++) {
                if (data[i][0].equals(ManagePerson.pList.get(j).id)) {
                    System.out.println(data[i][j] + " ");
                    ManagePerson.pList.get(j).id = String.valueOf(data[i][0]);
                    ManagePerson.pList.get(j).name = String.valueOf(data[i][1]);
                    ManagePerson.pList.get(j).age = Integer.valueOf(data[i][2] + "");
                    ManagePerson.pList.get(j).gender = String.valueOf(data[i][3]).charAt(0);
                    ManagePerson.pList.get(j).phone = String.valueOf(data[i][4]);
                    ManagePerson.pList.get(j).address = String.valueOf(data[i][5]);
                }
            }
            System.out.println("");
        }
    }

}
