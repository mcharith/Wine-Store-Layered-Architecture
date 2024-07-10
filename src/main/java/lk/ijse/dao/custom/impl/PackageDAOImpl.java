package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PackageDAO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Item;
import lk.ijse.entity.Package;
import lk.ijse.entity.PackageDetails;
import lk.ijse.entity.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDAOImpl implements PackageDAO {
    @Override
    public ArrayList<Package> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Package> allPackages = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Package");
        while (rst.next()){
            Package Package = new Package(rst.getString("Package_id"),rst.getString("Description")
                    ,rst.getDouble("Price"),rst.getInt("Qty"));
            allPackages.add(Package);
        }
        return allPackages;
    }

    @Override
    public boolean add(Package entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Package (Package_id,Description,Price,Qty) VALUES(?,?,?,?)",
                entity.getPackageId(),entity.getDescription(),entity.getPrice(),entity.getQty());
    }

    @Override
    public boolean update(Package entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Package SET Description = ?, Price = ?, Qty = ? WHERE Package_id = ?",
                entity.getDescription(),entity.getPrice(),entity.getQty(),entity.getPackageId());
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
        return SQLUtil.execute("DELETE FROM Package WHERE Package_id = ?",id);
    }

    @Override
    public Package search(String desc) throws SQLException, ClassNotFoundException {
        System.out.println("desc"+desc);
        ResultSet rst = SQLUtil.execute("SELECT * FROM Package WHERE Package_id = ?",desc);
        rst.next();
        return new Package(rst.getString("Package_id"),desc + "",rst.getDouble("Price"),
                rst.getInt("Qty"));
    }
    public List<String> getDescription() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Description FROM Package";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<String>descList = new ArrayList<>();

        try {
            while (resultSet.next()){
                descList.add(resultSet.getString("Description"));
            }
        }finally {
            if (resultSet != null){
                resultSet.close();
            }
        }
        return descList;
    }
    public Package searchByDescription(String desc) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Package WHERE Description = ?";

        try (ResultSet resultSet = SQLUtil.execute(sql,desc)) {
            if (resultSet.next()) {
                return new Package(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4)
                );
            }
        }
        return null;
    }
}
