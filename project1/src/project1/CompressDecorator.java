package project1;

import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.io.*;

public class CompressDecorator extends BaseDataSourceDecorator{
    public CompressDecorator(DataSource wrappee)
    {
        super(wrappee);
    }

    @Override
    public void Write(String data) {
        String compressed = compress(data);
        _wrappee.Write(compressed);
    }

    @Override
    public String Read() {
        String compressedData = _wrappee.Read();
        return decompress(compressedData);
    }

    private String compress(String data) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data.getBytes("UTF-8"));
            gzip.close();
            byte[] compressed = bos.toByteArray();
            bos.close();
            // Convert to Base64 for string storage
            return java.util.Base64.getEncoder().encodeToString(compressed);
        } catch (IOException e) {
            System.err.println("Compression error: " + e.getMessage());
            return data;
        }
    }

    private String decompress(String compressedData) {
        try {
            byte[] compressed = java.util.Base64.getDecoder().decode(compressedData);
            ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            BufferedReader br = new BufferedReader(new InputStreamReader(gzip, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            gzip.close();
            bis.close();
            return sb.toString();
        } catch (IOException e) {
            System.err.println("Decompression error: " + e.getMessage());
            return compressedData;
        }
    }
}
