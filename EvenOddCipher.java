// Name: Anushka Angamuthu, x500: angam003
/**Class that implements a EvenOdd Cipher which inherits from BaseCipher*/
public class EvenOddCipher extends BaseCipher {

    /**
     * initializes a EvenOddCipher object
     */
    public EvenOddCipher() {
        super("Even Odd Cipher");
    }

    /**
     * describes a Even Odd Cipher object
     * @return String displaying the Even Odd Cipher object
     */
    public String toString() {
        return "EvenOddCipher";
    }

    /**
     * determines if two Even Odd Cipher objects are equal
     * @param other Object the other object
     * @return boolean true if an Even Odd Cipher object false if not
     */
    public boolean equals (Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof EvenOddCipher) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * encrypts a message using a Even Odd Cipher
     * @param text String the message to be encrypted
     * @return String the encrypted message
     */
    public String encrypt(String text) {
        String encrypted = "";
        for (int i = 0; i < text.length(); i+=2) {
            encrypted += text.charAt(i);
        }
        for (int i = 1; i < text.length(); i+=2) {
            encrypted += text.charAt(i);
        }
        return encrypted;

    }

    /**
     * decrypts a message using a Even Odd Cipher
     * @param text String the message to be decrypted
     * @return String the decrypted message
     */
    public String decrypt (String text) {
        int mid = (text.length() + 1)/2;
        String firstHalf = text.substring(0,mid);
        String secondHalf = text.substring(mid);

        String decrypted = "";
        int firstHalfCount = 0;
        int secondHalfCount = 0;
        for (int i = 0; i < text.length(); i++){
            if (i % 2 == 0) {
               decrypted += firstHalf.charAt(firstHalfCount);
               firstHalfCount ++;
            }
            else {
                decrypted += secondHalf.charAt(secondHalfCount);
                secondHalfCount ++;
            }
        }
        return decrypted;
    }
}
