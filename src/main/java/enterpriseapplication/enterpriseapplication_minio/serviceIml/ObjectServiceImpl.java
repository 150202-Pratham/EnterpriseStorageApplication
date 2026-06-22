package enterpriseapplication.enterpriseapplication_minio.serviceIml;

import enterpriseapplication.enterpriseapplication_minio.entity.FileMetadata;
import enterpriseapplication.enterpriseapplication_minio.exception.FileUploadException;
import enterpriseapplication.enterpriseapplication_minio.repository.FileMetaDataRepository;
import enterpriseapplication.enterpriseapplication_minio.service.ObjectService;
import enterpriseapplication.enterpriseapplication_minio.util.CheckSumUtil;
import enterpriseapplication.enterpriseapplication_minio.util.FileStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.time.Instant;
import java.util.UUID;

@Service
public class ObjectServiceImpl implements ObjectService {

    private final  S3Client s3client ;
    private final FileMetaDataRepository repository ;

    public ObjectServiceImpl(S3Client s3client , FileMetaDataRepository repository) {
        this.s3client = s3client;
        this.repository = repository ;

    }

    public FileMetadata upload(MultipartFile file , String bucketName , String uploadedBy){

        try{
            String originalFileName = file.getOriginalFilename() ;
            String extension = "" ;
            int index = originalFileName.lastIndexOf(".");
            if(index!=-1){
                extension = originalFileName.substring(index) ;
            }
            String storedName = UUID.randomUUID().toString()+extension ;
            String checkSum = CheckSumUtil.sha256(file.getInputStream()) ;

            PutObjectRequest req = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(storedName)
                    .contentType(file.getContentType())
                    .build() ;
            PutObjectResponse res = s3client.putObject(req , RequestBody.fromBytes(file.getBytes()));

            FileMetadata metaData = new FileMetadata() ;
            metaData.setOriginalName(originalFileName);
            metaData.setStoredName(storedName);
            metaData.setBucketName(bucketName);
            metaData.setUploadedAt(Instant.now());
            metaData.setUploadedBy(uploadedBy);
            metaData.setChecksum(checkSum);
            metaData.setFileSize(file.getSize());
            metaData.setContentType(file.getContentType());
            metaData.setEtag(res.eTag()) ;
            metaData.setStatus(FileStatus.ACTIVE) ;

            return repository.save(metaData) ;


        }
        catch(Exception e){
            throw new FileUploadException(e.getMessage());

        }
    }



}
