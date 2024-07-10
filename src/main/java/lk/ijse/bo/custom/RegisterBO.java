package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RegisterDTO;
import lk.ijse.entity.Register;

import java.sql.SQLException;

public interface RegisterBO extends SuperBO {
    public boolean addNewUser(RegisterDTO dto) throws SQLException, ClassNotFoundException;
}
