package enterpriseapplication.enterpriseapplication_minio.service;

import enterpriseapplication.enterpriseapplication_minio.entity.FileMetadata;
import org.springframework.web.multipart.MultipartFile;

public interface ObjectService {

    FileMetadata upload(MultipartFile file , String bucketName , String uploadedBy) ;
}
