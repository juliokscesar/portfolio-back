package com.portback.portfolioback;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;


public class Utility {

    public static String convertFileToBase64(String imagePath) throws IOException {
        File file = new File(imagePath);

        if(!file.exists() || !file.isFile()){
            throw new IOException("O arquivo especificado não existe ou não é um arquivo válido: " +imagePath);
        }

        byte[] fileContent = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
