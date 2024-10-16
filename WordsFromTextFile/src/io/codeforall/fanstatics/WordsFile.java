package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class WordsFile implements Iterable<String> {

    private String fileText;

    public WordsFile(String filePath) throws IOException {

        FileReader reader = new FileReader(filePath);

        // wrap the file reader using a buffered reader
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        fileText = "";

        // using the buffered reader we can read lines
        while ((line = bReader.readLine()) != null) {
            fileText += line + " ";
        }

        bReader.close();

    }


    @Override
    public Iterator<String> iterator() {

        // String normalizedString = fileText.replaceAll("^[\s^\\w][.,]", "");

        String[] words = fileText.split("[^a-zA-z0-9]+");


        return new Iterator<String>() {

            int i = -1;

            @Override
            public boolean hasNext() {
                i++;
                return i < words.length;
            }

            @Override
            public String next() {
                return words[i];
            }
        };
    }
}
