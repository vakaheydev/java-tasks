package tasks.vigenere;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AlphabetParser {
    private String filePath;

    public AlphabetParser(String filePath) {
        this.filePath = filePath;
    }

    public Alphabet parse() {
        return Alphabet.of(filePath);
    }

    public void commonInitialize() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            int cnt = 0;

            for (int i = 'A'; i <= (int) 'Z'; i++) {
                writer.write((char) i + ";" + cnt++ + "\n");
            }

            for (int i = 'a'; i <= (int) 'z'; i++) {
                writer.write((char) i + ";" + cnt++ + "\n");
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
