package DBUtils.category;

import DBUtils.DAO;
import DBUtils.DBHelper;
import quizz.Category;

import java.sql.PreparedStatement;
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
    public List<Category> getAll() {
        List<Category> items = new ArrayList<>();

        if(dbHelper != null) {
            try {
                Statement database = dbHelper.getStatement();
                ResultSet result = database.executeQuery("SELECT * FROM Category");

                while (result.next()) {
                    items.add(new Category(result.getInt("idCategory"), result.getString("name")));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return items;
    }

    @Override
    public Category get(int id) {
        if(dbHelper != null) {
            String query = "SELECT name FROM Category WHERE idCategory = ?";
            try {
                PreparedStatement preparedStatement = dbHelper.getPreparedStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet result = preparedStatement.executeQuery();
                if (result.first()) {
                    return new Category(id, result.getString("name"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
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
