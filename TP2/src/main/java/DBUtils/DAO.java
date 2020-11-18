package DBUtils;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T get(int id);
    boolean update(int id, T item);
    boolean delete(int id);
    boolean add(T item);
}
