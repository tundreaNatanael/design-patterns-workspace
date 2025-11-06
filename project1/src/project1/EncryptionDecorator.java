package project1;

import java.util.zip.GZIPInputStream;

public class EncryptionDecorator extends BaseDataSourceDecorator{

    public EncryptionDecorator(DataSource wrappee)
    {
        super(wrappee);
    }

    @Override
    public void Write(String data) {

        _wrappee.Write("encrypted: "+data);
    }

    @Override
    public String Read() {
        return _wrappee.Read();
    }
}
