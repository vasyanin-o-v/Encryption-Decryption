package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlgorithmMaker {
    String mode = "";
    int key = 0;
    String in = "";
    String out = "";
    String data = "";
    Algorithm algorithm = new ShiftAlgorithm();


    void doMagic() {
        readFromFile();

        switch (mode) {
            case "enc":
                String massage = algorithm.encrypt(data, key);
                writeToFile(massage, out);
                break;
            case "dec":
                String cipherMassage = algorithm.decrypt(data, key);
                writeToFile(cipherMassage, out);
                break;
            default:
                System.out.println("Error mode");
        }
    }

    public void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-alg":
                    switch (args[i + 1]) {
                        case "shift":
                            algorithm = new ShiftAlgorithm();
                            break;
                        case "unicode":
                            algorithm = new UnicodeAlgorithm();
                            break;
                        default:
                            System.err.println("unknown algorithm " + args[i + 1]);
                            System.exit(1);
                    }
                    break;
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
                default:
                    System.err.println("unknown argument");
                    System.exit(1);
            }
        }
    }

    private void readFromFile() {
        if (data.equals("")) {
            File file = new File(in);
            try (Scanner fileScanner = new Scanner(file)) {
                data = fileScanner.nextLine();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
    }

    private void writeToFile(String text, String out) {
        if ("".equals(out)) {
            System.out.println(text);
        } else {
            File file = new File(out);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
