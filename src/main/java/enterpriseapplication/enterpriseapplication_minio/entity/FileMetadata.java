package enterpriseapplication.enterpriseapplication_minio.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "file_metaData")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileMetadata {

    @Id
    private String id;

    private String originalName;

    private String storedName;

    private String bucketName;

    private Long fileSize;

    private String contentType;

    private String uploadedBy;

    private Instant uploadedAt;

    private String etag;

    private String checksum;

    private String status;
}
