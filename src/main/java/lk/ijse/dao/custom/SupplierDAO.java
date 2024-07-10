package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO extends CrudDAO<Supplier> {
    public List<String> getSupplierName() throws SQLException, ClassNotFoundException;
    public Supplier searchBySupplierName(String supplierName) throws SQLException, ClassNotFoundException;
}
