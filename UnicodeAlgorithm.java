package encryptdecrypt;

public class UnicodeAlgorithm implements Algorithm {
    @Override
    public String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            c += key;
            result.append(c);
        }
        return result.toString();
    }

    @Override
    public String decrypt(String text, int key) {
        return encrypt(text, -key);
    }
}
