package enterpriseapplication.enterpriseapplication_minio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CopyRequest {

    private String sourceBucket ;
    private String targetBucket ;
    private String objectKey ;

}
