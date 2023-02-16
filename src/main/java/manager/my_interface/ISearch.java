package manager.my_interface;

import java.util.List;

public interface ISearch<E>{
    E findById(int id);
    public List<E> findByName(String value);
}
