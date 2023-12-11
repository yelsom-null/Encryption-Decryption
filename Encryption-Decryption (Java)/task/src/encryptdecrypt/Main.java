import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    enum Algorithm {
        SHIFT, UNICODE
    }

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String inFile = null;
        String outFile = null;
        Algorithm algorithm = Algorithm.SHIFT;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    if (i + 1 < args.length) mode = args[i + 1];
                    break;
                case "-key":
                    if (i + 1 < args.length) key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    if (i + 1 < args.length) data = args[i + 1];
                    break;
                case "-in":
                    if (i + 1 < args.length) inFile = args[i + 1];
                    break;
                case "-out":
                    if (i + 1 < args.length) outFile = args[i + 1];
                    break;
                case "-alg":
                    if (i + 1 < args.length) algorithm = "unicode".equals(args[i + 1]) ? Algorithm.UNICODE : Algorithm.SHIFT;
                    break;
            }
        }

        if (data.isEmpty() && inFile != null) {
            try {
                data = new String(Files.readAllBytes(Paths.get(inFile)));
            } catch (IOException e) {
                System.out.println("Error: Cannot read file: " + inFile);
                return;
            }
        }

        String result = "enc".equals(mode) ? encrypt(data, key, algorithm) : decrypt(data, key, algorithm);

        if (outFile != null) {
            try (FileWriter writer = new FileWriter(outFile)) {
                writer.write(result);
            } catch (IOException e) {
                System.out.println("Error: Cannot write to file: " + outFile);
            }
        } else {
            System.out.println(result);
        }
    }

    private static String encrypt(String message, int key, Algorithm algorithm) {
        return algorithm == Algorithm.SHIFT ? shiftEncrypt(message, key) : unicodeEncrypt(message, key);
    }

    private static String decrypt(String message, int key, Algorithm algorithm) {
        return algorithm == Algorithm.SHIFT ? shiftDecrypt(message, key) : unicodeDecrypt(message, key);
    }

    private static String shiftEncrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) (((character - base + key) % 26) + base);
            }
            result.append(character);
        }
        return result.toString();
    }

    private static String shiftDecrypt(String message, int key) {
        return shiftEncrypt(message, 26 - (key % 26));
    }

    private static String unicodeEncrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            result.append((char) (character + key));
        }
        return result.toString();
    }

    private static String unicodeDecrypt(String message, int key) {
        return unicodeEncrypt(message, -key);
    }
}
