package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.PackageDTO;
import lk.ijse.entity.PackageDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PackageBO extends SuperBO {
    public ArrayList<PackageDTO> getAllPackages() throws SQLException, ClassNotFoundException;
    public boolean addPackage(PackageDTO packageDTO) throws SQLException, ClassNotFoundException;
    public boolean updatePackage(PackageDTO packageDTO) throws SQLException, ClassNotFoundException;
    public boolean deletePackage(String id) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
}
