package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SupplierBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.SupplierDTO;
import lk.ijse.entity.Item;
import lk.ijse.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    @Override
    public ArrayList<SupplierDTO> getAllSuppliers() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDTO>allSuppliers = new ArrayList<>();
        ArrayList<Supplier>all = supplierDAO.getAll();
        for (Supplier supplier : all){
            allSuppliers.add(new SupplierDTO(supplier.getSupId(),supplier.getName(),supplier.getAddress(),
                    supplier.getEmail(),supplier.getTele()));
        }
        return allSuppliers;
    }

    @Override
    public boolean addSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return supplierDAO.add(new SupplierDTO(supplierDTO.getSupId(),supplierDTO.getName(),supplierDTO.getAddress()
                ,supplierDTO.getEmail(),supplierDTO.getTele()));
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new SupplierDTO(supplierDTO.getSupId(),supplierDTO.getName(),supplierDTO.getAddress()
                ,supplierDTO.getEmail(),supplierDTO.getTele()));
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(id);
    }
}
