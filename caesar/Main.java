package tasks.caesar;

public class Main {
    private static final String ALPHABET_PATH = "C:\\Users\\Vaka\\IdeaProjects\\StudyingExactlyJava\\src\\main\\java" +
            "\\tasks" +
            "\\caesar" +
            "\\alphabet.txt";

    public static void main(String[] args) {
        var processor = getProcessor();
        processor.process();
    }

    private static ConsoleProcessor getProcessor() {
        AlphabetParser parser = new AlphabetParser(ALPHABET_PATH);
        parser.commonInitialize();
        var cypher = CaesarCypher.create(parser);
        return new ConsoleProcessor(cypher);
    }
}
