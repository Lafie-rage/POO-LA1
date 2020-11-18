package DBUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements Repository {
    List<String> items = new ArrayList<>();
    CategoryDAO dao = new CategoryDAO();

    @Override
    public List<String> getAll() {
        return dao.getAll();
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
