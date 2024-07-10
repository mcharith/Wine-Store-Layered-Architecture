package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PurchesePackageBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.*;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.*;
import lk.ijse.entity.*;
import lk.ijse.entity.Package;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchesePackageBOImpl implements PurchesePackageBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    StaffDAO staffDAO = (StaffDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STAFF);
    PackageDAO packageDAO = (PackageDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PACKAGE);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    PackageDetailsDAO packageDetailsDAO = (PackageDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PACKAGEDETAILS);

    @Override
    public CustomerDTO searchCustomer(String tele) throws SQLException, ClassNotFoundException {
        Customer c = customerDAO.search(tele);
        return new CustomerDTO(c.getCusId(),c.getCusName(),c.getCusAddress(),c.getCusNum());
    }

    @Override
    public ItemDTO searchItem(String desc) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getuserName() throws SQLException, ClassNotFoundException {
        return staffDAO.getuserName();
    }

    @Override
    public Staff searchByUserName(String userName) throws SQLException, ClassNotFoundException {
        return staffDAO.searchByUserName(userName);
    }

    @Override
    public List<String> getDescription() throws SQLException, ClassNotFoundException {
        return packageDAO.getDescription();
    }

    @Override
    public Package searchByDescription(String desc) throws SQLException, ClassNotFoundException {
        return packageDAO.searchByDescription(desc);
    }

    @Override
    public Customer searchByContact(String tele) throws SQLException, ClassNotFoundException {
        return customerDAO.searchByContact(tele);
    }

    @Override
    public boolean purchasePackage(OrderDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            System.out.println("7777");
            System.out.println(dto);
            boolean b1 = orderDAO.add(new Order(dto.getOrder_id(),dto.getCustomer_id(),dto.getDate()));
            System.out.println("jjj");
            if (!b1){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            for (PackageDetailsDTO dto1 : dto.getPackageDetailsDTOS()){
                PackageDetails packageDetails = new PackageDetails(dto1.getOrder_id(),dto1.getPackage_id(),dto1.getQty(), dto1.getUnitPrice());
                boolean b2 = packageDetailsDAO.add(packageDetails);
                if ( !b2){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                System.out.println("888");
                PackageDTO packageDTO = findPackage(dto1.getPackage_id());
                packageDTO.setQty(packageDTO.getQty()-dto1.getQty());

                boolean b3 = packageDAO.update(new Package(packageDTO.getPackageId(),packageDTO.getDescription(),
                        packageDTO.getPrice(),packageDTO.getQty()));
                if ( !b3){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
    public PackageDTO findPackage(String packageId) throws SQLException, ClassNotFoundException {
        try {
            System.out.println(packageId);
            Package p = packageDAO.search(packageId);
            return new PackageDTO(p.getPackageId(),p.getDescription(),p.getPrice(),p.getQty());
        }catch (SQLException e){
            throw new RuntimeException("Failed to Find Package" + packageId,e);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
