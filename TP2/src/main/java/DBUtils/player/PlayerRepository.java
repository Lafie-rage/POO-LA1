package DBUtils.player;

import DBUtils.DBHelper;
import DBUtils.Repository;
import quizz.Category;
import quizz.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PlayerRepository implements Repository<Player> {
    DBHelper dbHelper;

    public PlayerRepository() {
        try {
            dbHelper = new DBHelper();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Player> getAll() {
        return null;
    }

    public int getCountPlayer() {
        if(dbHelper != null) {
            try {
                Statement database = dbHelper.getStatement();
                ResultSet result = database.executeQuery("SELECT COUNT(*) as count FROM Player");
                if (result.first())
                    return result.getInt("count");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public Player get(int id) {
        if(dbHelper != null) {
            String query = "SELECT name, pseudo, password FROM Player WHERE idPlayer = ?";
            try {
                PreparedStatement preparedStatement = dbHelper.getPreparedStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet result = preparedStatement.executeQuery();
                if (result.first()) {
                    return new Player(id, result.getString("name"), result.getString("pseudo"), result.getString("password"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean update(int id, Player item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(Player item) {
        return false;
    }
}
