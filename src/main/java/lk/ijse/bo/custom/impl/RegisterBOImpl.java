package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RegisterBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.RegisterDAO;
import lk.ijse.dto.RegisterDTO;
import lk.ijse.entity.Register;

import java.sql.SQLException;

public class RegisterBOImpl implements RegisterBO {
    RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REGISTER);
    @Override
    public boolean addNewUser(RegisterDTO dto) throws SQLException, ClassNotFoundException {
        return registerDAO.add(new Register(dto.getUser_id(), dto.getFirst_name(), dto.getLast_name(),
                dto.getEmail(), dto.getPassword()));
    }
}
