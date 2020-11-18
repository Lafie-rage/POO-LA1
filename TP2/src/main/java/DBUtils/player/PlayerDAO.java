package DBUtils.player;

import DBUtils.DAO;
import DBUtils.category.CategoryDAO;
import quizz.Category;
import quizz.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements DAO<Player> {
    PlayerDAO dao = new PlayerDAO();

    @Override
    public List<Player> getAll() {
        return null;
    }

    public int getCountPlayer() {
        return dao.getCountPlayer();
    }

    @Override
    public Player get(int id) {
        return dao.get(id);
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
