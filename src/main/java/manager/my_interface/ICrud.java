package manager.my_interface;

import java.util.List;

public interface ICrud<E> {
    List<E> findAll();
    void save (E e);
    void update(int index,E e);
    void delete(E e);
}
