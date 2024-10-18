package tasks.vigenere;

import java.io.*;
import java.nio.file.Files;

public class ConsoleProcessor {
    private final BufferedReader reader;
    private final static int CYPHER_INTO_FILE = 1;
    private final static int DECIPHER_FROM_FILE = 2;
    private static VigenereCypher cypher;

    public ConsoleProcessor(VigenereCypher cypher) {
        this.cypher = cypher;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void process() {
        File file = getFile();

        while (true) {
            resolveProcess(file);
            String data = getData("Для завершения введите end");

            if ("end".equals(data)) {
                return;
            }
        }
    }

    private void resolveProcess(File file) {
        int processNum = getInt("Шифруем (1) или расшифровываем? (2)?\nУкажите 1 или 2");

        switch (processNum) {
            case CYPHER_INTO_FILE -> processWrite(file);
            case DECIPHER_FROM_FILE -> processRead(file);
            default -> resolveProcess(file);
        }
    }

    private void processWrite(File file) {
        String data = getData("Укажите данные для шифрования");
        String key = getData("Укажите ключ");

        String encryptedData = cypher.encrypt(data, key);
        writeIntoFile(file, encryptedData);
    }

    private void processRead(File file) {
        String key = getData("Укажите ключ");
        String encryptedData = readFromFile(file);
        String decryptedData = cypher.decrypt(encryptedData, key);

        System.out.println("Расшифрованные данные:\n" + decryptedData);
    }

    private void writeIntoFile(File file, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readFromFile(File file) {
        try {
            return Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int getInt(String prompt) {
        System.out.println(prompt);
        int data = 0;

        try {
            data = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            getInt(prompt);
        }

        if (data == 0) {
            return getInt(prompt);
        }

        return data;
    }

    private File getFile() {
        System.out.println("Укажите путь к файлу");

        String path;
        try {
            path = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Указанного файла не существует");
            return getFile();
        }

        return file;
    }

    private String getData(String prompt) {
        System.out.println(prompt);
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
