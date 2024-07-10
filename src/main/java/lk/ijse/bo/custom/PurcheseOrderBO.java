package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.dto.OrderPlaceDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.entity.Package;
import lk.ijse.entity.Staff;

import java.sql.SQLException;
import java.util.List;

public interface PurcheseOrderBO extends SuperBO {
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public List<String> getuserName() throws SQLException, ClassNotFoundException;
    public Staff searchByUserName(String userName) throws SQLException, ClassNotFoundException;
    public List<String> getDescription() throws SQLException, ClassNotFoundException ;
    public Item searchByDescription(String desc) throws SQLException, ClassNotFoundException;
    public Customer searchByContact(String tele) throws SQLException, ClassNotFoundException;
    boolean purchaseOrder(OrderPlaceDTO dto) throws SQLException, ClassNotFoundException;
    public Item searchById(String code) throws SQLException, ClassNotFoundException;
}
