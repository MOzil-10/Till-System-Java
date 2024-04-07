package service;
import models.TillModel;

import java.io.*;
import java.util.Properties;

public class FileWriterHandler {
    private final PropertiesReader properties;
    public FileWriterHandler(){
       properties =  PropertiesReader.getInstance();
    }
    public void saveLineToFile(TillModel tillModel) {

        // Get file path from properties
        String filePath = properties.getPropertyValue("outputFilePath");

        try {
            // Check if file exists
            File file = new File(filePath);
            boolean fileExists = file.exists();

            // If file doesn't exist, create it and write the initial line
            if (!fileExists) {
               // file.createNewFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    writer.write("Till Start, Transaction Total, Paid, Change total, Change Breakdown");
                    writer.newLine();
                }
            }

            // Append the new line to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                String line = "R" + tillModel.getTillBalance() + ", " +
                        "R" + tillModel.getTotalTransaction() + ", " +
                        "R" + tillModel.getAmountPaid() + ", " +
                        "R" + tillModel.getChange() + ", " +
                        tillModel.getChangeBreakDown();

                writer.write(line);
                writer.newLine();
                System.out.println("Line saved to file successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error occurred while saving line to file: " + e.getMessage());
        }
    }
}


