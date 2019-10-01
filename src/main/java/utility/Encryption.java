package utility;

import org.apache.commons.codec.binary.Base64;


public class Encryption {

    public static String decodeString(String password) {
        byte[] decodedString = Base64.decodeBase64(password);
        return (new String(decodedString));
    }

    public static String encodeString(String password) {
        byte[] encodedString = Base64.encodeBase64(password.getBytes());
        return new String(encodedString);
    }

    //Test Encryption
    public static void main(String[] args) {
        String encoded = encodeString("Erap2rz#");
        System.out.println("Encoded String is: " + encoded);

        String decoded = decodeString(encoded);
        System.out.println("Decoded String is: " + decoded);
    }


}
