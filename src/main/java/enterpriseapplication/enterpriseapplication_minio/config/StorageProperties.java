package enterpriseapplication.enterpriseapplication_minio.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "app.storage")
public class StorageProperties {
    private String endPoint ;
    private String accessKey ;
    private String secretKey ;
    private String region ;


}
