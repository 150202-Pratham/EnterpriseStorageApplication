package enterpriseapplication.enterpriseapplication_minio.controller;

import enterpriseapplication.enterpriseapplication_minio.entity.FileMetadata;
import enterpriseapplication.enterpriseapplication_minio.exception.BucketNotFoundException;
import enterpriseapplication.enterpriseapplication_minio.exception.InvalidFileException;
import enterpriseapplication.enterpriseapplication_minio.service.ObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.Bucket;

@RequestMapping("/api/objects")
@RestController
public class ObjectController {

    public final ObjectService objservice;

    public ObjectController(ObjectService objService){
        this.objservice = objService ;
    }

    @PostMapping("/upload")
    public FileMetadata upload(@RequestParam("file") MultipartFile file , @RequestParam String bucketName , @RequestParam String uploadedBy){

        if(file==null || file.isEmpty()){
            throw new InvalidFileException("File Not Found") ;

        }
        if(bucketName==null || bucketName.isEmpty()){
            throw new BucketNotFoundException("Bucket Not Found") ;

        }
        return objservice.upload(file,bucketName,uploadedBy) ;
    }
}
