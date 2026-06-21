package enterpriseapplication.enterpriseapplication_minio.repository;

import enterpriseapplication.enterpriseapplication_minio.entity.BucketAudit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BucketAuditRepository extends MongoRepository<BucketAudit, String> {


}
