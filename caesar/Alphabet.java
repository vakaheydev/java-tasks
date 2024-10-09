package tasks.caesar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

class Alphabet {
    private final static Pattern pairPattern = Pattern.compile("\\w;\\d+");
    private final Map<Character, Integer> charToInt;
    private final Map<Integer, Character> intToChar;

    private Alphabet(Map<Character, Integer> charToInt, Map<Integer, Character> intToChar) {
        this.charToInt = charToInt;
        this.intToChar = intToChar;
    }

    public static Alphabet of(String filePath) {
        Map<Character, Integer> charToInt = new HashMap<>();
        Map<Integer, Character> intToChar = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));

            for (String line : lines) {
                if (!pairPattern.matcher(line).matches()) {
                    System.out.println("Некорректный формат. Должно быть \"Буква;Число\", например: \"A;0\"");
                    throw new RuntimeException("Некорректный формат алфавита");
                }
                String[] split = line.split(";");
                char c = split[0].charAt(0);
                int key = Integer.parseInt(split[1]);
                charToInt.put(c, key);
                intToChar.put(key, c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Alphabet(charToInt, intToChar);
    }

    public char getChar(int key) {
        return intToChar.get(key);
    }

    public int getKey(char c) {
        return charToInt.get(c);
    }

    public int size() {
        return charToInt.size();
    }

    public boolean contains(char c) {
        return charToInt.containsKey(c);
    }
}
