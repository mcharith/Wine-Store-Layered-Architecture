package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Supplier>allSuppliers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Supplier");
        while (rst.next()){
            Supplier supplier = new Supplier(rst.getString("Supplier_id"),rst.getString("Supplier_name"),
                    rst.getString("Supplier_address"),rst.getString("Supplier_email"),
                    rst.getString("Supplier_telephone"));
            allSuppliers.add(supplier);
        }
        return allSuppliers;
    }
    @Override
    public boolean add(Supplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Supplier(Supplier_id,Supplier_name,Supplier_address,Supplier_email,Supplier_telephone)" +
                "VALUES(?,?,?,?,?)",entity.getSupId(),entity.getName(),entity.getAddress(),entity.getEmail(),entity.getTele());
    }

    @Override
    public boolean update(Supplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customers SET Supplier_name = ?, Supplier_address = ?, Supplier_tel = ?," +
                "Supplier_email WHERE Supplier_id = ?",entity.getSupId(),entity.getName(),
                entity.getAddress(),entity.getEmail(),entity.getTele());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Supplier WHERE Supplier_id = ?",id);
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Supplier WHERE Supplier_id = ?",id + "");
        rst.next();
        return new Supplier(id + "", rst.getString("Supplier_name"), rst.getString("Supplier_address"),
                rst.getString("Supplier_email"),rst.getString("Supplier_telephone"));
    }

    @Override
    public List<String> getSupplierName() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Supplier_name FROM Supplier";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<String>nameList = new ArrayList<>();

        try {
            while (resultSet.next()){
                nameList.add(resultSet.getString("Supplier_name"));
            }
        }finally {
            if (resultSet != null){
                resultSet.close();
            }
        }
        return nameList;
    }

    @Override
    public Supplier searchBySupplierName(String supplierName) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Supplier WHERE Supplier_name = ?";

        try (ResultSet resultSet = SQLUtil.execute(sql,supplierName)) {
            if (resultSet.next()) {
                return new Supplier(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
        }
        return null;
    }
}
