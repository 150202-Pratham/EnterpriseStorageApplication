package enterpriseapplication.enterpriseapplication_minio.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bucket_audit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BucketAudit {
    @Id
    private String id;

    private String bucketName;
    private String operation;
    private Long timestamp;


}
