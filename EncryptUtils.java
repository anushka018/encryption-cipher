/**Class that encrypts and decrypted a combination of multiple ciphers*/
public class EncryptUtils {

    /**
     * encrypts each String in the array using the BaseCipher
     * @param cipher BaseCipher
     * @param messages String[]
     * @return String[] each String encrypted using the BaseCipher
     */
    public static String[] encryptMany(BaseCipher cipher, String [] messages){
        String [] encrypted = new String [messages.length];
        for (int i = 0; i < messages.length; i++) {
            encrypted[i] = cipher.encrypt(messages[i]);
        }
        return encrypted;
    }

    /**
     * decrypts each String in the array using the BaseCipher
     * @param cipher BaseCipher
     * @param messages String[]
     * @return String[] each String decrypted using the BaseCipher
     */
    public static String[] decryptMany(BaseCipher cipher, String [] messages){
        String [] decrypted = new String [messages.length];
        for (int i = 0; i < messages.length; i++) {
            decrypted[i] = cipher.decrypt(messages[i]);
        }
        return decrypted;
    }
}
