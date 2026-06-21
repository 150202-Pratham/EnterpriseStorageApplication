package enterpriseapplication.enterpriseapplication_minio.exception;

public class ObjectNotFoundException extends StorageException {

	public ObjectNotFoundException(String objectName) {

		super("Object not found : " + objectName);
	}
}