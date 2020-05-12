/** Class that implements a Caesar Cipher which inherits from BaseCipher */
public class CaesarCipher extends BaseCipher{
    private int keyVal;

    /**
     * initializes a CaesarCipher object
     * @param keyVal int amount to rotate by
     */
    public CaesarCipher(int keyVal) {
        super("Caesar Cipher");
        this.keyVal = keyVal;
    }

    /**
     * determines if keyVal is valid (between 1 and 25)
     * @return boolean true if valid false if not
     */
    public boolean isValid() {
        return this.keyVal >= 1 && this.keyVal <= 25;
    }

    /**
     * encrypts a message using a Caesar Cipher
     * @param text String the message to be encrypted
     * @return String the encrypted message
     */
    public String encrypt(String text) {
        String output = "";
        for (int i = 0; i < text.length(); i++) {
            char c = 'c';
            if (Character.isAlphabetic(text.charAt(i))) {
                if (Character.isUpperCase(text.charAt(i))) {
                    c = Character.toLowerCase(text.charAt(i));
                } else {
                    c = text.charAt(i);
                }
                int pos = (int) ((int) c - 'a');
                if (pos + keyVal >= 26) {
                    pos = (pos + keyVal) % 26;
                } else {
                    pos = pos + keyVal;
                }
                int newPos = (int) (pos + 'a');
                output += (char) newPos;
            } else {
                output += text.charAt(i);
            }
        }
        return output;
    }

    /**
     * decrypts a message using a Caesar Cipher
     * @param text String the message to be decrypted
     * @return String the decrypted message
     */
    public String decrypt(String text) {
        String output = "";
        for (int i = 0; i < text.length(); i++) {
            char c = 'c';
            if (Character.isAlphabetic(text.charAt(i))) {
                if (Character.isUpperCase(text.charAt(i))) {
                    c = Character.toLowerCase(text.charAt(i));
                } else {
                    c = text.charAt(i);
                }
                int pos = (int) ((int) c - 'a');
                if (pos - keyVal < 0) {
                    pos = 26 + (pos - keyVal);
                } else {
                    pos = pos - keyVal;
                }
                int newPos = (int) (pos + 'a');
                output += (char) newPos;
            } else {
                output += text.charAt(i);
            }
        }
        return output;
    }

    /**
     * describes a Caesar Cipher object
     * @return String displaying the Caesar Cipher object
     */
    public String toString() {
        return "Caesar(" + keyVal + ")";
    }

    /**
     * determines if two Caesar Cipher objects are equal
     * @param other Object the other object
     * @return boolean true if the same keyVal false if not
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof CaesarCipher) {
            CaesarCipher caesarCipher = (CaesarCipher) other;
            return this.keyVal == caesarCipher.keyVal;
        } else {
            return false;
        }

    }
}
