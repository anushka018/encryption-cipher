import java.util.Arrays;
/**Class that implements a Super Cipher formed by applying a chain of ciphers and inherits from BaseCipher*/
public class SuperCipher extends BaseCipher{
    private BaseCipher [] ciphers;

    /**
     * initializes a SuperCipher object
     * @param ciphers BaseCipher[] the array of BaseCipher objects
     */
    public SuperCipher (BaseCipher [] ciphers) {
        super("Super Cipher");
        this.ciphers = ciphers;
    }

    /**
     * determines if each Base Cipher is valid
     * @return boolean true if all valid false if not
     */
    public boolean isValid() {
        for (int i = 0; i < ciphers.length; i++){
            if (!ciphers[i].isValid()) {
                return false;
            }
        }
        return true;
    }

    /**
     * describes a Super Cipher object
     * @return String displaying the Super Cipher object
     */
    public String toString() {
        String cipherToStrings = "";
        for (int i = 0; i < ciphers.length; i++) {
            cipherToStrings += ciphers[i].toString();
            if (i >= 0 && i!=ciphers.length-1 && ciphers.length!=1){
                cipherToStrings += " | ";
            }
        }
        cipherToStrings += ")";
        return "SuperCipher(" + cipherToStrings;
    }

    /**
     * determines if two Super Cipher objects are equal
     * @param other Object the other object
     * @return boolean true if the chain of ciphers match, false if not
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof SuperCipher) {
            SuperCipher otherCiphers = (SuperCipher) other;
            return Arrays.equals(this.ciphers, otherCiphers.ciphers);
        } else {
            return false;
        }
    }

    /**
     * reverses each cipher to the message provided
     * @param message String the message to be encrypted
     * @return String the encrypted message
     */
    public String encrypt (String message) {
        String encrypted = this.ciphers[0].encrypt(message);
        for (int i = 1; i < this.ciphers.length ; i++) {
            encrypted = this.ciphers[i].encrypt(encrypted);
        }
        return encrypted;
    }

    /**
     * applies each cipher to the message provided
     * @param message String the message to be decrypted
     * @return String the decrypted message
     */
    public String decrypt (String message) {
        String decrypted = ciphers[0].decrypt(message);
        for (int i = 1; i < ciphers.length ; i++) {
            decrypted = ciphers[i].decrypt(decrypted);
        }
        return decrypted;
    }
}
