package enterpriseapplication.enterpriseapplication_minio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RenameRequest {

    private String newName ;
    private String oldName ;
    private String bucketName ;

}
