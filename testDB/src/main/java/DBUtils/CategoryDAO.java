package DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements DAO {
    DBHelper dbHelper;

    public CategoryDAO() {
        try {
            dbHelper = new DBHelper();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<String> getAll() {
        List<String> items = new ArrayList<>();

        if(dbHelper == null) return items;
        try {
            Statement database = dbHelper.getDatabase();
            ResultSet result = database.executeQuery("SELECT * FROM Category");

            while(result.next()) {
                items.add(result.getInt("idCategory") + " : " + result.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Object item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(Object item) {
        return false;
    }
}
