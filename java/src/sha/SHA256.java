package sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    private static MessageDigest SHA256;
    private static StringBuffer sb;

    public static String getSHA256HexToString(String aPassword) throws NoSuchAlgorithmException {
        SHA256 = MessageDigest.getInstance("SHA-256");
        sb = new StringBuffer();

        byte[] result = SHA256.digest(aPassword.getBytes());
        for(int i = 0; i<result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        String SHA256Hex =  sb.toString();

        return SHA256Hex;
    }
}
