package io.project.services;

import io.project.models.WorkLog;
import io.project.repositories.WorkLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author armenar
 */
public class WorkLogRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private WorkLogRepository workLogRepository;

    public void updateDomain() {
        WorkLog findFirstByDomain = workLogRepository.findFirstByDomain("log");
        mongoTemplate.save(findFirstByDomain);

    }

}
