package tasks.vigenere;

public class VigenereCypher {
    private Alphabet alphabet;

    private VigenereCypher() {
    }

    public static VigenereCypher create(AlphabetParser alphabetParser) {
        VigenereCypher cypher = new VigenereCypher();
        cypher.alphabet = alphabetParser.parse();
        return cypher;
    }

    public String encrypt(String data, String key) {
        StringBuilder sb = new StringBuilder();

        int n = key.length();
        int keyCnt = 0;

        for (char c : data.toCharArray()) {
            char cKey = key.charAt(keyCnt);
            char encrypted = shiftRight(c, cKey);
            sb.append(encrypted);

            keyCnt = (keyCnt + 1) % n;
        }

        return sb.toString();
    }
    public String decrypt(String data, String key) {
        StringBuilder sb = new StringBuilder();

        int n = key.length();
        int keyCnt = 0;

        for (char c : data.toCharArray()) {
            char cKey = key.charAt(keyCnt);
            char encrypted = shiftLeft(c, cKey);
            sb.append(encrypted);

            keyCnt = (keyCnt + 1) % n;
        }

        return sb.toString();
    }

    private char shiftLeft(char c, char key) {
        if (!canBeProcessed(c)) {
            return c;
        }

        int val = alphabet.getKey(c);
        int newVal = ((val - alphabet.getKey(key)) + alphabet.size()) % alphabet.size();

        return alphabet.getChar(newVal);
    }

    private char shiftRight(char c, char key) {
        if (!canBeProcessed(c)) {
            return c;
        }

        int val = alphabet.getKey(c);
        int newVal = (val + alphabet.getKey(key)) % alphabet.size();

        return alphabet.getChar(newVal);
    }

    private boolean canBeProcessed(char c) {
        return alphabet.contains(c);
    }
}
