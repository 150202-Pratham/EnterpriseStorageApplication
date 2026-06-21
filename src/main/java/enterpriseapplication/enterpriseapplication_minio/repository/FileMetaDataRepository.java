package enterpriseapplication.enterpriseapplication_minio.repository;

import enterpriseapplication.enterpriseapplication_minio.entity.FileMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FileMetaDataRepository extends MongoRepository<FileMetadata, String> {

    List<FileMetadata> findByUploadedBy(String uploadedBy);
    List<FileMetadata> findByBucketName(String bucketName) ;
    List<FileMetadata> findByStatus(String status ) ;
    List<FileMetadata> findByOriginalNameContainingIgnoreCase(String name); 

}
