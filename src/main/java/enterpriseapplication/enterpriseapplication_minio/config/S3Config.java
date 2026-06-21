package enterpriseapplication.enterpriseapplication_minio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class S3Config {
       private final StorageProperties storage;
       public S3Config(StorageProperties storage) {
           this.storage = storage;

       };

       @Bean
        public S3Client s3Client() {
           return S3Client.builder()
                   .endpointOverride(
                           URI.create(storage.getEndPoint()))
                   .credentialsProvider(
                           StaticCredentialsProvider.create(
                                   AwsBasicCredentials.create(
                                           storage.getAccessKey(),
                                           storage.getSecretKey())))
                   .region(
                           Region.of(
                                   storage.getRegion()))
                   .forcePathStyle(true)
                   .build();
       }
}
