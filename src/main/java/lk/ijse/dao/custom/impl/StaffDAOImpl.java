package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RegisterDAO;
import lk.ijse.dao.custom.StaffDAO;
import lk.ijse.entity.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {
    @Override
    public ArrayList<Staff> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Staff>allMembers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Staff");
        while (rst.next()){
            Staff staff = new Staff(rst.getString("Staff_id"),rst.getString("Name"),
                    rst.getString("Address"),rst.getString("Age"),
                    rst.getString("Contact_number"),rst.getString("Job_Role"));
            allMembers.add(staff);
        }
        return allMembers;
    }

    @Override
    public boolean add(Staff entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Staff(Staff_id,Name,Address,Age,Contact_number,Job_Role)" +
                "VALUES(?,?,?,?,?,?)",entity.getStaff_id(),entity.getName(),entity.getAddress(),entity.getAge(),
                entity.getContact_number(),entity.getJob_Role());
    }

    @Override
    public boolean update(Staff entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Staff SET Name = ?, Address = ?, Age = ?,Contact_number =?, Job_Role =? WHERE Staff_id = ?",
                entity.getStaff_id(),entity.getName(),entity.getAddress(),entity.getAge(),entity.getContact_number(),entity.getJob_Role());
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
        return SQLUtil.execute("DELETE FROM Staff WHERE Staff_id = ?",id);
    }

    @Override
    public Staff search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
    public List<String> getuserName() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Name FROM Staff";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<String> userNameList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                userNameList.add(resultSet.getString("Name"));
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return userNameList;
    }
    public Staff searchByUserName(String userName) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Staff WHERE Name = ?";

        try (ResultSet resultSet = SQLUtil.execute(sql, userName)) {
            if (resultSet.next()) {
                return new Staff(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
        }

        return null;
    }
}
