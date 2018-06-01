/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.table.model;

import com.verisec.realestateeth.domain.Offer;
import com.verisec.realestateeth.domain.RealEstate;
import java.math.BigInteger;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natasa Vatres
 */
public class OfferTableModel extends AbstractTableModel {

    private final List<Offer> offers;
    private String[] columnNames = new String[]{"Location", "Your price", "Offered price"};

    public OfferTableModel(List<Offer> offers) {
        this.offers = offers;
    }


    @Override
    public int getRowCount() {
        return offers == null ? 0 : offers.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Offer offer = offers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return offer.getRealEstate().getRealEstateAddress();
            case 1:
                return offer.getRealEstate().getPrice();
            case 2:
                return offer.getOffer();
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
