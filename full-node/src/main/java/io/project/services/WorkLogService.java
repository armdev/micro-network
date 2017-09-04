package io.project.services;

import com.mongodb.WriteResult;
import io.project.models.WorkLog;
import io.project.repositories.WorkLogRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author armenar
 */
@Service
@Scope("singleton")
@Component
public class WorkLogService implements WorkLogRepository<WorkLog> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<WorkLog> getAllObjects() {
        return mongoTemplate.findAll(WorkLog.class);
    }

    @Override
    public void saveObject(WorkLog entity) {
        mongoTemplate.insert(entity);
    }

    @Override
    public WorkLog getObject(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
                WorkLog.class);
    }

    @Override
    public WriteResult updateObject(String id, String worklog) {
        return mongoTemplate.updateFirst(
                new Query(Criteria.where("id").is(id)),
                Update.update("worklog", worklog), WorkLog.class);
    }

    @Override
    public void deleteObject(String id) {
        mongoTemplate
                .remove(new Query(Criteria.where("id").is(id)), WorkLog.class);
    }

    @Override
    public void createCollection() {
        if (!mongoTemplate.collectionExists(WorkLog.class)) {
            mongoTemplate.createCollection(WorkLog.class);
        }
    }

    @Override
    public void dropCollection() {
        if (mongoTemplate.collectionExists(WorkLog.class)) {
            mongoTemplate.dropCollection(WorkLog.class);
        }
    }

}
