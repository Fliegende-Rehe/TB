package ru.telegram.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Txt {
    public static String getText(final String PATH) {
        try {
            StringBuilder text = new StringBuilder();
            BufferedReader buffer = new BufferedReader(new FileReader(PATH));
            String line = buffer.readLine();
            while(line != null){
                text.append(line).append("\n");
                line = buffer.readLine();
            }
            return text.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "you are dumb";
        }
    }
}
