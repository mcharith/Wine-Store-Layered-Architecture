package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Package;
import lk.ijse.entity.PackageDetails;

import java.sql.SQLException;
import java.util.List;

public interface PackageDAO extends CrudDAO<Package> {
    public List<String> getDescription() throws SQLException, ClassNotFoundException ;
    public Package searchByDescription(String desc) throws SQLException, ClassNotFoundException;
}
