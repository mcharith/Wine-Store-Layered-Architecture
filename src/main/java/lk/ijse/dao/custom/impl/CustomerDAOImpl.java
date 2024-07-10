package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        while (rst.next()) {
            Customer customer = new Customer(rst.getString("Customer_id"), rst.getString("Name"),
                    rst.getString("Address"),rst.getString("Contact_number"));
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public boolean add(Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer (Customer_id,Name,Address,Contact_number) VALUES (?,?,?,?)",
                entity.getCusId(), entity.getCusName(), entity.getCusAddress(),entity.getCusNum());
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Customer SET Name=?, Address=?, Contact_number = ? WHERE Customer_id=?",
                entity.getCusName(), entity.getCusAddress(), entity.getCusNum(),entity.getCusId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE Customer_id=?", id);
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE Contact_number = ?", id + "");
        rst.next();
        return new Customer(id + "",rst.getString("cusName"),
                rst.getString("cusAddress"),rst.getString("Contact_number"));
    }
    public Customer searchByContact(String tele) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Customer WHERE Contact_number = ?";

        try (ResultSet resultSet = SQLUtil.execute(sql, tele)) {
            if (resultSet.next()) {
                String cus_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String tel = resultSet.getString(4);

                return new Customer(cus_id, name, address, tel);
            }
        }
        return null;
    }
}