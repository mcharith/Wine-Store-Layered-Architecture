package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StaffBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.StaffDAO;
import lk.ijse.dto.StaffDTO;
import lk.ijse.entity.Staff;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffBoImpl implements StaffBO {
    StaffDAO staffDAO = (StaffDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STAFF);
    @Override
    public ArrayList<StaffDTO> getAllStaff() throws SQLException, ClassNotFoundException {
       ArrayList<StaffDTO>allStaffs = new ArrayList<>();
       ArrayList<Staff>all = staffDAO.getAll();
       for (Staff staff:all){
           allStaffs.add(new StaffDTO(staff.getStaff_id(),staff.getName(),staff.getAddress(),staff.getAge(),staff.getContact_number(),
                   staff.getJob_Role()));
       }
       return allStaffs;
    }

    @Override
    public boolean addStaff(StaffDTO staffDTO) throws SQLException, ClassNotFoundException {
        return staffDAO.add(new Staff(staffDTO.getStaff_id(),staffDTO.getName(),staffDTO.getAddress(),
                staffDTO.getAge(),staffDTO.getContact_number(),staffDTO.getJob_Role()));
    }

    @Override
    public boolean updateStaff(StaffDTO staffDTO) throws SQLException, ClassNotFoundException {
        return staffDAO.update(new Staff(staffDTO.getStaff_id(),staffDTO.getName(),staffDTO.getAddress(),
                staffDTO.getAge(),staffDTO.getContact_number(),staffDTO.getJob_Role()));
    }

    @Override
    public boolean existStaff(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewStaffID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteStaff(String id) throws SQLException, ClassNotFoundException {
        return staffDAO.delete(id);
    }

    @Override
    public List<String> getuserName() throws SQLException, ClassNotFoundException {
        return staffDAO.getuserName();
    }
}
