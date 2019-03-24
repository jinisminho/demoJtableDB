/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hoang Pham
 */
public class SVModel extends AbstractTableModel {

    Vector<Obj> itemList;
    
    public SVModel(Vector<Obj> itemList) {
        this.itemList = itemList;
    }

    public Vector<Obj> getItemList() {
        return itemList;
    }

    public void setItemList(Vector<Obj> itemList) {
        this.itemList = itemList;
    }

    public int getRowCount() {
        return itemList.size();
    }

    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        String columnName = "";
        switch (column) {
            case 0:
                columnName = "Username";
                break;
            case 1:
                columnName = "Fullname";
                break;
            case 2:
                columnName = "Password";
                break;
            case 3:
                columnName = "Role";
                break;
        }
        return columnName;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Obj item = itemList.get(row);
        Object obj = null;
        switch (column) {
            case 0:
                obj = item.getUsername();
                break;
            case 1:
                obj = item.getFullname();
                break;
            case 2:
                obj = item.getPassword();
                break;
            case 3:
                obj = item.getRole();
                break;
        }

        return obj;
    }

}
