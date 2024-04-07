package service;

import java.io.*;

public class FileReaderHandler {
   private final BufferedReader br;

    public FileReaderHandler(){
        PropertiesReader properties = PropertiesReader.getInstance();

        try {
            br = new BufferedReader(new FileReader(properties.getPropertyValue("inputFilePath")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String readLine(){
            String line; // Read only the first line
        try {
            if((line = br.readLine()) != null) {
                return  line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}