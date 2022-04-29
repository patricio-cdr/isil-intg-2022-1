package pe.isil.service;

import java.util.List;
import java.util.Optional;

// Interfaz en donde le enviamos dos parametros, el T hace referencia a la clase y
// el ID es de que tipo es el id del modelo (Student)
//
public interface BaseService<T, ID> {

    void create(T t);
    List<T> read();
    void update(T t);
    void delete(T t);
    Optional<T> readById(ID id);

}
