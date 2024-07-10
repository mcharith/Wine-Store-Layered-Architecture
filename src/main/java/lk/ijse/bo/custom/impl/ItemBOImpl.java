package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Item;
import lk.ijse.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO>allItems = new ArrayList<>();
        ArrayList<Item>all = itemDAO.getAll();
        for (Item item : all){
            allItems.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnit_price(),item.getQty_on_hand(),
                    item.getBuying_price(),item.getSupplier_id()));
        }
        return allItems;
    }

    @Override
    public boolean addItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new ItemDTO(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnit_price(),
                itemDTO.getQty_on_hand(),itemDTO.getBuying_price(),itemDTO.getSupplier_id()));
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new ItemDTO(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnit_price(),itemDTO.getQty_on_hand(),
                itemDTO.getBuying_price(),itemDTO.getSupplier_id()));
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }

    @Override
    public Item search(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }

    @Override
    public List<String> getSupplierName() throws SQLException, ClassNotFoundException {
        return supplierDAO.getSupplierName();
    }

    @Override
    public Supplier searchBySupplierName(String supplierName) throws SQLException, ClassNotFoundException {
        return supplierDAO.searchBySupplierName(supplierName);
    }

    @Override
    public Item searchById(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.searchById(code);
    }
}
