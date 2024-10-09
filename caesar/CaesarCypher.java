package tasks.caesar;

public class CaesarCypher {
    private Alphabet alphabet;

    private CaesarCypher() {
    }

    public static CaesarCypher create(AlphabetParser alphabetParser) {
        CaesarCypher cypher = new CaesarCypher();
        cypher.alphabet = alphabetParser.parse();
        return cypher;
    }

    public String encrypt(String data, int key) {
        StringBuilder sb = new StringBuilder();

        for (char c : data.toCharArray()) {
            System.out.print(c + " ");
            char encrypted = shiftRight(c, key);
            System.out.print(encrypted + "\n");
            sb.append(encrypted);
        }

        return sb.toString();
    }

    public String decrypt(String data) {
        StringBuilder resSb = new StringBuilder();

        for (int key = 0; key < alphabet.size(); key++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Key ").append(key).append(" | ");
            for (char c : data.toCharArray()) {
                char encrypted = shiftLeft(c, key);
                sb.append(encrypted);
            }
            resSb.append(sb).append("\n");
        }

        return resSb.toString();
    }

    public String decrypt(String data, int key) {
        StringBuilder sb = new StringBuilder();

        for (char c : data.toCharArray()) {
            char encrypted = shiftLeft(c, key);
            sb.append(encrypted);
        }

        return sb.toString();
    }

    private char shiftLeft(char c, int key) {
        if (!canBeProcessed(c)) {
            return c;
        }

        int val = alphabet.getKey(c);
        int newVal = ((val - key) + alphabet.size()) % alphabet.size();

        return alphabet.getChar(newVal);
    }

    private char shiftRight(char c, int key) {
        if (!canBeProcessed(c)) {
            return c;
        }

        int val = alphabet.getKey(c);
        int newVal = (val + key) % alphabet.size();

        return alphabet.getChar(newVal);
    }

    private boolean canBeProcessed(char c) {
        return alphabet.contains(c);
    }
}
