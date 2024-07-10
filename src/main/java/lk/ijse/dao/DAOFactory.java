package lk.ijse.dao;

import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,SUPPLIER,PACKAGE,STAFF,ORDER,PACKAGEDETAILS,REGISTER,ORDERDETAILS
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER :
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case PACKAGE:
                return new PackageDAOImpl();
            case STAFF:
                return new StaffDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case PACKAGEDETAILS:
                return new PackageDetailsDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            default:
                return null;
        }
    }
}
