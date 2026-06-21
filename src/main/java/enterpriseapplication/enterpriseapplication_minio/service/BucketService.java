package enterpriseapplication.enterpriseapplication_minio.service;

import enterpriseapplication.enterpriseapplication_minio.dto.BucketRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BucketService {

    ResponseEntity<Void> createBucket(BucketRequest bucketRequest);

	boolean bucketExists(String bucketName);

	ResponseEntity<List<String>> listBuckets();

	ResponseEntity<String> deleteBucket(String bucketName);
}
