package enterpriseapplication.enterpriseapplication_minio.controller;

import enterpriseapplication.enterpriseapplication_minio.dto.BucketRequest;
import enterpriseapplication.enterpriseapplication_minio.service.BucketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.s3.model.Bucket;

import java.util.List;

@RestController
public class BucketController {

    private final BucketService bucketService ;

    private BucketController(BucketService service){
        this.bucketService = service ;
    }

    @PostMapping
    public ResponseEntity<Void> createBucket(@RequestBody BucketRequest bucketRequest){
         return bucketService.createBucket(bucketRequest);

    }

    @DeleteMapping("/{bucketName}")
    public ResponseEntity<String>  deleteBucket(@PathVariable("bucketName") String bucketName){
        return bucketService.deleteBucket(bucketName);

    }

    @GetMapping
    public ResponseEntity<List<String>> getAllBuckets(){
        return bucketService.listBuckets() ;

    }


}
