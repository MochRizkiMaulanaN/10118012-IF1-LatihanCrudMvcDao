/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rizkimaulana.latihanmvcjdbc.model;

import edu.rizkimaulana.latihanmvcjdbc.entity.Pelanggan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class TabelPelangganModel extends AbstractTableModel{
    
    private List<Pelanggan> list = new ArrayList<Pelanggan>();

    public void setList(List<Pelanggan> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public boolean add(Pelanggan e) {
        try {
           return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Pelanggan get(int i) {
        return list.get(i);
    }

    public Pelanggan set(int i, Pelanggan e) {
        try {
            return list.set(i, e);
        } finally{
            fireTableRowsUpdated(i, i);
        }
    }

    public Pelanggan remove(int i) {
        try {
            return list.remove(i);
        } finally {
            fireTableRowsDeleted(i, i);
        }
    }
    
    
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : 
                return "id";
            case 1 : 
                return "nama";
            case 2 : 
                return "alamat";
            case 3 : 
                return "telepon";
            case 5 : 
                return "email";
                
            default: return null;
        }
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex){
             case 0 : 
                 return list.get(rowIndex).getId();
             case 1 : 
                 return list.get(rowIndex).getNama();
             case 2 : 
                 return list.get(rowIndex).getAlamat();
             case 3 : 
                 return list.get(rowIndex).getTelepon();
             case 4 : 
                 return list.get(rowIndex).getEmail();
                 
             default: return null;
         }
    }
    
}
