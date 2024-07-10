package lk.ijse.bo.custom.impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.PurcheseOrderBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.*;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import lk.ijse.dto.OrderDetailDTO;
import lk.ijse.dto.OrderPlaceDTO;
import lk.ijse.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PurcheseOrderBOImpl implements PurcheseOrderBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    StaffDAO staffDAO = (StaffDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STAFF);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
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
        return itemDAO.getDescription();
    }

    @Override
    public Item searchByDescription(String desc) throws SQLException, ClassNotFoundException {
        return itemDAO.searchByDescription(desc);
    }

    @Override
    public Customer searchByContact(String tele) throws SQLException, ClassNotFoundException {
        return customerDAO.searchByContact(tele);
    }

    @Override
    public boolean purchaseOrder(OrderPlaceDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection  = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean b1 = orderDAO.add(new Order(dto.getOrder_id(),dto.getCustomer_id(),dto.getDate()));
            //System.out.println("b1"+b1);
            if (!b1){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            for (OrderDetailDTO dto1 : dto.getOrderDetailDTOS()){
                OrderDetail orderDetail = new OrderDetail(dto1.getOrder_id(),dto1.getItem_code(),dto1.getQty(),dto1.getUnitPrice());
                boolean b2 = orderDetailsDAO.add(orderDetail);
                if (!b2){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                ItemDTO item = findItem(dto1.getItem_code());
                item.setQty_on_hand(item.getQty_on_hand()-dto1.getQty());

                boolean b3 = itemDAO.update(new Item(item.getCode(),item.getDescription(), item.getUnit_price(), item.getQty_on_hand(),
                        item.getBuying_price(), item.getSupplier_id()));
                if (!b3){
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

    @Override
    public Item searchById(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.searchById(code);
    }

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
        try {
            Item i = itemDAO.search(code);
            System.out.println(itemDAO);
            return new ItemDTO(i.getCode(),i.getDescription(), i.getUnit_price(), i.getQty_on_hand(), i.getBuying_price(), i.getSupplier_id());
        }catch (SQLException e){
            throw new RuntimeException("Failed find the Item" + code,e);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
