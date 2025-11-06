package project1;

public class StorageDataSource implements DataSource{
    @Override
    public void Write(String data) {
        System.out.println(data);
    }

    @Override
    public String Read() {
        return "Storage data read";
    }
}
