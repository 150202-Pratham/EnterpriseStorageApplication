package enterpriseapplication.enterpriseapplication_minio.exception;

public class BucketNotFoundException extends StorageException {

	public BucketNotFoundException(String bucketName) {

		super("Bucket not found : " + bucketName);
	}
}