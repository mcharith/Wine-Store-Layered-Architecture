package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Item;
import lk.ijse.entity.Package;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {
    public List<String> getDescription() throws SQLException, ClassNotFoundException;
    public Item searchByDescription(String desc) throws SQLException, ClassNotFoundException;
    public Item searchById(String code) throws SQLException, ClassNotFoundException;
}
