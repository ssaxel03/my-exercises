package io.codeforall.fanstatics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileCopy {

    public static void CopyFile(String file, String outputLocation) {

        FileInputStream inputStream;
        FileOutputStream outputStream;

        int bytesProcessed;

        try {
            inputStream = new FileInputStream(file);
            System.out.println("FILE INPUT STREAM CREATED");

            outputStream = new FileOutputStream(outputLocation);
            System.out.println("FILE OUTPUT STREAM CREATED");

            bytesProcessed = 0;
            byte[] buffer = new byte[1024];

            while (bytesProcessed % 1024 == 0 && bytesProcessed != -1) {

                bytesProcessed = inputStream.read(buffer);
                int i= 0;

                outputStream.write(buffer, 0, bytesProcessed);
                // content = content.concat(buffer.);
            }

            System.out.println("File copied");

        } catch (Exception e) {
            System.out.println("Error reading file");
            System.out.println(e.getMessage());
        }
    }
}