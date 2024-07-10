package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
       ArrayList<Item> allitems = new ArrayList<>();
       ResultSet rst = SQLUtil.execute("SELECT * FROM Items");
       while (rst.next()){
           Item item = new Item(rst.getString("Item_code"),rst.getString("Description")
                   ,rst.getDouble("unit_price"),rst.getInt("qty_on_hand"),rst.getDouble("buying_price"),
                   rst.getString("Supplier_id")
           );
           allitems.add(item);
       }
       return allitems;
    }

    @Override
    public boolean add(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Items(Item_code,Description,unit_price,qty_on_hand,buying_price," +
                "Supplier_id) VALUES(?,?,?,?,?,?)",entity.getCode(),entity.getDescription(),entity.getUnit_price(),
                entity.getQty_on_hand(),entity.getBuying_price(),entity.getSupplier_id());
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Items SET Description=?, unit_price=?, qty_on_hand=?,buying_price=?," +
                "Supplier_id=? WHERE Item_code =?",entity.getDescription(),entity.getUnit_price(),entity.getQty_on_hand()
                ,entity.getBuying_price(),entity.getSupplier_id(),entity.getCode());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT Item_code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Items WHERE Item_code=?", id);
    }

    @Override
    public Item search(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Items WHERE Item_code=?",code + "");
        rst.next();
        return new Item(code + "",rst.getString("Description"),rst.getDouble("unit_price"),rst.getInt("qty_on_hand"),
                rst.getDouble("buying_price"),rst.getString("Supplier_id"));
    }
    public List<String> getDescription() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Description FROM Items";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<String>descList = new ArrayList<>();

        try {
            while (resultSet.next()){
                descList.add(resultSet.getString("Description"));
            }
        }finally {
            if (resultSet != null){
                resultSet.close();
            }
        }
        return descList;
    }
    public Item searchByDescription(String desc) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Items WHERE Description = ?";

        try (ResultSet resultSet = SQLUtil.execute(sql,desc)) {
            if (resultSet.next()) {
                return new Item(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6)
                );
            }
        }
        return null;
    }
    public Item searchById(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM items WHERE Item_code = ?";
        try (ResultSet resultSet = SQLUtil.execute(sql, code)) {
            if (resultSet.next()) {
                return new Item(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6)
                );
            }
        }
        return null;
    }
}
