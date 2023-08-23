package coursework;

import java.nio.charset.StandardCharsets;	
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MyCipher {
	private static final String algo = "AES";
	
	public static String encrypt(String strToEncrypt, String secretKey) throws Exception{
		Key key = generateKey(secretKey);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8));
		return new String(encryptedBytes, StandardCharsets.ISO_8859_1);
		
	}
	
	public static String decrypt(String strToDecrypt, String secretKey) throws Exception{
		Key key = generateKey(secretKey);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptedBytes = cipher.doFinal(strToDecrypt.getBytes(StandardCharsets.ISO_8859_1));
		return new String(decryptedBytes, StandardCharsets.UTF_8);
		
	}

	public static Key generateKey(String secretKey) {
		byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
		return new SecretKeySpec(keyBytes, algo);
	}
}
