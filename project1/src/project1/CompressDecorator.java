package project1;

public class CompressDecorator extends BaseDataSourceDecorator{
    public CompressDecorator(DataSource wrappee)
    {
        super(wrappee);
    }

    @Override
    public void Write(String data) {
        _wrappee.Write("Compress:"+data);
    }

    @Override
    public String Read() {
        return _wrappee.Read();
    }
}
