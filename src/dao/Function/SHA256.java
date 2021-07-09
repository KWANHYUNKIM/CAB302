package dao.Function;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * SHA-256
 * It changes the String value to sha-256 encryption.
 * @author baeldung , javannspring
 */
public class SHA256 {

    public static String getHash(String password, String salt) {
        return getHash(password, salt.getBytes());
    }

    public static String getHash(String password, byte[] salt) {

        String result = "";

        byte[] encodedhash = password.getBytes();
        byte[] bytes = new byte[encodedhash.length + salt.length];

        System.arraycopy(encodedhash, 0, bytes, 0, encodedhash.length);
        System.arraycopy(salt, 0, bytes, encodedhash.length, salt.length);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);

            byte[] hash = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 256, 16).substring(1));
            }

            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String generateSalt() {
        Random random = new Random();

        byte[] salt = new byte[8];
        random.nextBytes(salt);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < salt.length; i++) {

            sb.append(String.format("%01x",salt[i]));
        }

        return sb.toString();
    }

}
/**
 * reference https://www.baeldung.com/sha-256-hashing-java
 *  https://javannspring.tistory.com/105
**/