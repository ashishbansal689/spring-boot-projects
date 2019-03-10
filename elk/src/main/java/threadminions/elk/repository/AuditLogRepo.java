package threadminions.elk.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import threadminions.elk.model.AuditLog;

public interface AuditLogRepo extends ElasticsearchRepository<AuditLog, Integer> {
}
