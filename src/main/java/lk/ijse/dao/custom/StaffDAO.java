package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffDAO extends CrudDAO<Staff> {
    public List<String> getuserName() throws SQLException, ClassNotFoundException;
    public Staff searchByUserName(String userName) throws SQLException, ClassNotFoundException;
}
