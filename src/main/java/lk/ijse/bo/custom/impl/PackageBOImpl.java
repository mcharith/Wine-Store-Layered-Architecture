package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PackageBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PackageDAO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.dto.PackageDTO;
import lk.ijse.entity.Item;
import lk.ijse.entity.Package;
import lk.ijse.entity.PackageDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageBOImpl implements PackageBO {
    PackageDAO packageDAO = (PackageDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PACKAGE);
    @Override
    public ArrayList<PackageDTO> getAllPackages() throws SQLException, ClassNotFoundException {
        ArrayList<PackageDTO>allPackage = new ArrayList<>();
        ArrayList<Package>all = packageDAO.getAll();
        System.out.println("mam");
        for (Package pack : all){
            allPackage.add(new PackageDTO(pack.getPackageId(),pack.getDescription(),pack.getPrice(),pack.getQty()));
            System.out.println(all);
        }
        return allPackage;
    }

    @Override
    public boolean addPackage(PackageDTO dto) throws SQLException, ClassNotFoundException {
        return packageDAO.add(new Package(dto.getPackageId(),dto.getDescription(),dto.getPrice(),dto.getQty()));
    }

    @Override
    public boolean updatePackage(PackageDTO packageDTO) throws SQLException, ClassNotFoundException {
        return packageDAO.update(new Package(packageDTO.getPackageId(),packageDTO.getDescription(),packageDTO.getPrice(),
                packageDTO.getQty()));
    }

    @Override
    public boolean deletePackage(String id) throws SQLException, ClassNotFoundException {
        return packageDAO.delete(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
