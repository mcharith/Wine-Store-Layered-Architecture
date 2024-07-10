package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PackageDetailsDAO;
import lk.ijse.entity.PackageDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class PackageDetailsDAOImpl implements PackageDetailsDAO {
    @Override
    public ArrayList<PackageDetails> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This Feature is not implenemted yet");
    }

    @Override
    public boolean add(PackageDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Order_package_details (Order_id,Package_id,qty,unitPrice) VALUES(?, ?, ?, ?)",
                entity.getOrder_id(),entity.getPackage_id(),entity.getQty(),entity.getUnitPrice());
    }

    @Override
    public boolean update(PackageDetails entity) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This Feature is not implenemted yet");
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This Feature is not implenemted yet");
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This Feature is not implenemted yet");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This Feature is not implenemted yet");
    }

    @Override
    public PackageDetails search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This Feature is not implenemted yet");
    }
}
