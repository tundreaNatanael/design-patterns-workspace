package project1;

public class Main {

	public static void main(String[] args) {
		DataSource apiDs = new ApiDataSource();
		DataSource storageDs = new StorageDataSource();

		apiDs.Write("something");
		storageDs.Write("storage");

		DataSource ecryptionDecorator = new EncryptionDecorator(storageDs);
		ecryptionDecorator.Write("storage");

		DataSource compressDecorator = new CompressDecorator(ecryptionDecorator);
		compressDecorator.Write("storage");
	}

}
