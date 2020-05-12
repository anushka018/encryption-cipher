/**Class that implements a Word Replacement Cipher which inherits from BaseCipher*/
public class WordReplacementCipher extends BaseCipher{
    private String replaceFrom;
    private String replaceTo;

    /**
     * initializes a WordReplacementCipher object
     * @param replaceFrom String the text to replace
     * @param replaceTo String what the text should be replaced to
     */
    public WordReplacementCipher (String replaceFrom, String replaceTo) {
        super("Word Replacement Cipher");
        this.replaceFrom = replaceFrom;
        this.replaceTo = replaceTo;
    }

    /**
     * describes a Word Replacement Cipher object
     * @return String displaying the Word Replacement Cipher object
     */
    public String toString () {
        return "WordReplacementCipher(" +replaceFrom + ", " + replaceTo + ")";
    }

    /**
     * determines if two Word Replacement Cipher objects are equal
     * @param other Object the other object
     * @return boolean true if a Word Replacement Cipher object has the same replaceFrom and replaceTo strings,
     * false if not
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof WordReplacementCipher) {
            WordReplacementCipher wordReplacementCipher = (WordReplacementCipher) other;
            return this.replaceFrom.equals(wordReplacementCipher.replaceFrom) && this.replaceTo.equals
            (wordReplacementCipher.replaceTo);
        } else {
            return false;
        }

    }

    /**
     * encrypts a message using a Word Replacement Cipher
     * @param text String the message to be encrypted
     * @return String the encrypted message
     */
    public String encrypt(String text) {
        text = text.replace(replaceFrom, replaceTo);
        return text;
    }

    /**
     * decrypts a message using a Word Replacement Cipher
     * @param text String the message to be decrypted
     * @return String the decrypted message
     */
    public String decrypt (String text) {
        text = text.replace(replaceTo, replaceFrom);
        return text;
    }
}
