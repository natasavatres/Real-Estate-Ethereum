/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.table.model;

import com.verisec.realestateeth.domain.beans.RealEstate;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natasa Vatres
 */
public class RealEstateTableModel extends AbstractTableModel{
    
    private final List<RealEstate> realEstates;
    private String [] columnNames = new String[]{"Owner","Address","Area","Center distance","Price"};

    public RealEstateTableModel(List<RealEstate> realEstates) {
        this.realEstates = realEstates;
    }

    @Override
    public int getRowCount() {
        return realEstates == null ? 0 : realEstates.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RealEstate realEstate = realEstates.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return realEstate.getOwnerAddress();
            case 1:
                return realEstate.getRealEstateAddress();
            case 2:
                return realEstate.getArea();
            case 3:
                return realEstate.getCenterDistance();
            case 4:
                return realEstate.getPrice();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public void refreshTable(){
        fireTableDataChanged();
    }
}
