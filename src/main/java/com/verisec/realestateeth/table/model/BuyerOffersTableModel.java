/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verisec.realestateeth.table.model;

import com.verisec.realestateeth.domain.Offer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natasa Vatres
 */
public class BuyerOffersTableModel extends AbstractTableModel {

    private final List<Offer> allOffers;
    private String[] columnNames = new String[]{"Location", "Price", "Offered price", "Status"};

    public BuyerOffersTableModel(List<Offer> allOffers) {
        this.allOffers = allOffers;
    }

    @Override
    public int getRowCount() {
        return allOffers == null ? 0 : allOffers.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Offer offer = allOffers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return offer.getRealEstate().getRealEstateAddress();
            case 1:
                return offer.getRealEstate().getPrice();
            case 2:
                return offer.getOffer();
            case 3:
                return offer.getStatus();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void refreshTable() {
        fireTableDataChanged();
    }
    
    public List<Offer> getAllOffersList(){
        return allOffers;
    }
}
