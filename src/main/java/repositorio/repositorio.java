package repositorio;

import java.util.List;

public interface repositorio<T> {/* generico */
    List<T> listar();

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);
}
