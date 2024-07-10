package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    public BOFactory() {
    }
    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOTypes{
        CUSTOMER,ITEM,SUPPLIER,PACKAGE,STAFF,PACKAGEDETAILS,REGISTER,ORDERDETAILS
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER :
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case PACKAGE:
                return new PackageBOImpl();
            case STAFF:
                return new StaffBoImpl();
            case PACKAGEDETAILS:
                return new PurchesePackageBOImpl();
            case REGISTER:
                return new RegisterBOImpl();
            case ORDERDETAILS:
                return new PurcheseOrderBOImpl();
            default:
                return null;
        }
    }
}
