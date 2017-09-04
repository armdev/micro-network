package io.project.repositories;

import com.mongodb.WriteResult;
import java.util.List;

/**
 *
 * @author armdev
 * @param <T>
 */
public interface WorkLogRepository<T> {

    public List<T> getAllObjects();

    public void saveObject(T object);

    public T getObject(String id);

    public WriteResult updateObject(String id, String name);

    public void deleteObject(String id);

    public void createCollection();

    public void dropCollection();
}
