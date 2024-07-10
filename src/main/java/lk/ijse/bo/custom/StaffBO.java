package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.StaffDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StaffBO extends SuperBO {
    public ArrayList<StaffDTO> getAllStaff() throws SQLException, ClassNotFoundException;
    public boolean addStaff(StaffDTO staffDTO) throws SQLException, ClassNotFoundException;
    public boolean updateStaff(StaffDTO staffDTO) throws SQLException, ClassNotFoundException;
    public boolean existStaff(String id) throws SQLException, ClassNotFoundException;
    public String generateNewStaffID() throws SQLException, ClassNotFoundException;
    public boolean deleteStaff(String id) throws SQLException, ClassNotFoundException;
    public List<String> getuserName() throws SQLException, ClassNotFoundException;
}
