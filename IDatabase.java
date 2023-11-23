/**
 * DO NOT MODIFY THIS FILE
 */

import java.util.ArrayList;

public interface IDatabase<T> {
    void connect();
    void disconnect();

    void insert(T object);
    void update(T object, T newObject);
    void delete(T object);

    ArrayList<T> getAll();
}

