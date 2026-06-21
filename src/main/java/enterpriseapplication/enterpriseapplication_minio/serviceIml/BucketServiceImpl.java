package enterpriseapplication.enterpriseapplication_minio.serviceIml;

import enterpriseapplication.enterpriseapplication_minio.dto.BucketRequest;
import enterpriseapplication.enterpriseapplication_minio.exception.BucketNotFoundException;
import enterpriseapplication.enterpriseapplication_minio.service.BucketService;
import enterpriseapplication.enterpriseapplication_minio.validator.BucketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;

import java.util.ArrayList;
import java.util.List;


@Service
public class BucketServiceImpl implements BucketService {


    private final S3Client s3Client;

    public BucketServiceImpl(S3Client s3Client) {
        this.s3Client = s3Client;

    }
    public ResponseEntity<Void> createBucket(BucketRequest bucketRequest){
        String bucketName = bucketRequest.getBucketName() ;
        BucketValidator.validate(bucketName) ;
        CreateBucketRequest createBucketRequest = CreateBucketRequest.builder().bucket(bucketName).build();
        s3Client.createBucket(createBucketRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    public ResponseEntity<String> deleteBucket(String bucketName){
        BucketValidator.validate(bucketName) ;

        if(!bucketExists(bucketName)){
            throw new BucketNotFoundException("Bucket not found");
        }
        DeleteBucketRequest  deleBucketRequest = DeleteBucketRequest.builder().bucket(bucketName).build();
        s3Client.deleteBucket(deleBucketRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Bucket deleted Successfully");

    }
    public ResponseEntity<List<String>> listBuckets(){
        List<String> bucketNames = new ArrayList<>() ;
        List<Bucket>  bucket = s3Client.listBuckets().buckets();
        for(Bucket bucket1 : bucket){
            bucketNames.add(bucket1.name());
        }

        return ResponseEntity.status(HttpStatus.OK).body(bucketNames) ;
    }

    public boolean bucketExists(String bucketName){
        try{
            HeadBucketRequest request = HeadBucketRequest.builder().bucket(bucketName).build() ;
            s3Client.headBucket(request);
            return true ;
        }
        catch(Exception e){
            return false ;

        }
    }


}


