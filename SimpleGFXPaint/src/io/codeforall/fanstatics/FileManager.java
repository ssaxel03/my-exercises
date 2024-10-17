package io.codeforall.fanstatics;

import java.io.*;

public class FileManager {

    private static final String saveFilePath = "saveFiles/savedCanva.txt";

    public static void saveCanvas(Grid grid) throws IOException {

        System.out.println("IM SAVING");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saveFilePath));

        bufferedWriter.write("");

        bufferedWriter.write(grid.getSaveFile());

        bufferedWriter.close();

    }

    public static String loadCanvas() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFilePath));

        String read;
        String data = "";

        while((read = bufferedReader.readLine()) != null) {
            data += read;
            System.out.println(data);
        }

        bufferedReader.close();

        return data;

    }

}
