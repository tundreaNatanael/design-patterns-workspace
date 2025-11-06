package project1;

import java.io.*;
import java.nio.file.*;

public class StorageDataSource implements DataSource{
    // Constant for file path - change this before running
    private static final String FILE_PATH = "data.txt";

    @Override
    public void Write(String data) {
    	System.out.println(FILE_PATH);
        try {
            Files.write(Paths.get(FILE_PATH), data.getBytes());
            System.out.println("Data written to file: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public String Read() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(FILE_PATH));
            return new String(bytes);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return "";
        }
    }
}
