/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.repositories;

import io.project.models.WorkLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author armenar
 */
public interface WorkLogRepository extends MongoRepository<WorkLog, Long> {

    WorkLog findFirstByDomain(String worklog);

    WorkLog findByDomainAndDisplayAds(String worklog, boolean displayAds);

    //Supports native JSON query string
    @Query("{worklog:'?0'}")
    WorkLog findCustomByDomain(String worklog);

    @Query("{worklog: { $regex: ?0 } })")
    List<WorkLog> findCustomByRegExDomain(String worklog);

    public int updateDomain(String domain, boolean displayAds);
}
