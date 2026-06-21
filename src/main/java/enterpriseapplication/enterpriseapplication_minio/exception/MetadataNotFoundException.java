package enterpriseapplication.enterpriseapplication_minio.exception;

public class MetadataNotFoundException extends StorageException {

	public MetadataNotFoundException(String id) {

		super("Metadata not found : " + id);
	}
}