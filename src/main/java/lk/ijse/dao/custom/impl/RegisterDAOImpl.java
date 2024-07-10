package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RegisterDAO;
import lk.ijse.entity.Register;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public ArrayList<Register> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet.");
    }

    @Override
    public boolean add(Register entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO User(User_id,First_name,Last_name,Email,Password)VALUES(?, ?, ?,?,?)",
                entity.getUser_id(),entity.getFirst_name(),entity.getLast_name(),entity.getEmail(),entity.getPassword());
    }

    @Override
    public boolean update(Register entity) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This Feature is not impleneted yet.");
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This Feature is not implemented yet.");
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This is not implemented yet.");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("this is not implemented yet.");
    }

    @Override
    public Register search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This is not implementde yet.");
    }
}
