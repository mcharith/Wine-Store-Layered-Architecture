package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Package;
import lk.ijse.entity.Staff;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PurchesePackageBO extends SuperBO {
    public CustomerDTO searchCustomer(String tele) throws SQLException, ClassNotFoundException ;
    public ItemDTO searchItem(String desc) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    public List<String> getuserName() throws SQLException, ClassNotFoundException;
    public Staff searchByUserName(String userName) throws SQLException, ClassNotFoundException;
    public List<String> getDescription() throws SQLException, ClassNotFoundException ;
    public Package searchByDescription(String desc) throws SQLException, ClassNotFoundException;
    public Customer searchByContact(String tele) throws SQLException, ClassNotFoundException;
    boolean purchasePackage(OrderDTO dto) throws SQLException, ClassNotFoundException;
}
