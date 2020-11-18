package DBUtils.category;

import DBUtils.Repository;
import quizz.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements Repository {
    CategoryDAO dao = new CategoryDAO();

    @Override
    public List<Category> getAll() {
        return dao.getAll();
    }

    @Override
    public Category get(int id) {
        return dao.get(id);
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
