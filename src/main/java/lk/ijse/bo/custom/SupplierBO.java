package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.SupplierDTO;
import lk.ijse.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    public ArrayList<SupplierDTO> getAllSuppliers() throws SQLException, ClassNotFoundException;
    public boolean addSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
    public boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public Supplier search(String id) throws SQLException, ClassNotFoundException;
}
