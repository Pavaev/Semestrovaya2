package project.service;

import java.util.List;

public interface RestService<T> {

    T create(T object) throws Exception;

    T update(int id, T object) throws Exception;

    void delete(int id) throws Exception;

    List<T> getAll() throws Exception;

    T getObject(int id) throws Exception;


}
