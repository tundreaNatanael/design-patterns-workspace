package project1;

public class Main {

	public static void main(String[] args) {
		DataSource apiDs = new ApiDataSource();
		DataSource storageDs = new StorageDataSource();

		System.out.println("=== Test 1: Plain storage ===");
		apiDs.Write("something");
		storageDs.Write("plain storage data");
		System.out.println("Read from storage: " + storageDs.Read());
		System.out.println();

		System.out.println("=== Test 2: Encryption decorator ===");
		DataSource encryptionDecorator = new EncryptionDecorator(storageDs);
		encryptionDecorator.Write("encrypted storage data");
		System.out.println("Read from encrypted storage: " + encryptionDecorator.Read());
		System.out.println();

		System.out.println("=== Test 3: Compression + Encryption decorators ===");
		DataSource compressDecorator = new CompressDecorator(encryptionDecorator);
		compressDecorator.Write("compressed and encrypted data");
		System.out.println("Read from compressed+encrypted storage: " + compressDecorator.Read());
		System.out.println();

		System.out.println("=== Test 4: Verify file content is actually encrypted and compressed ===");
		System.out.println("Raw file content: " + storageDs.Read());
	}

}
