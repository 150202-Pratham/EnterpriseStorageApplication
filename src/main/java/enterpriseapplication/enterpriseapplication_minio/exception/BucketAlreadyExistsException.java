package enterpriseapplication.enterpriseapplication_minio.exception;


public class BucketAlreadyExistsException extends StorageException {

	public BucketAlreadyExistsException(String bucketName) {

		super("Bucket already exists : " + bucketName);
	}
}