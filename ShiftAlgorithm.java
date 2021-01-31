package encryptdecrypt;

public class ShiftAlgorithm implements Algorithm {
    @Override
    public String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int shift = Character.isUpperCase(c) ? 65 : 97;
                result.append((char) (modulo(c - shift + key) + shift));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    @Override
    public String decrypt(String text, int key) {
        return encrypt(text, -key);
    }

    private static int modulo(int x) {
        return (x % 26 + 26) % 26;
    }
}
