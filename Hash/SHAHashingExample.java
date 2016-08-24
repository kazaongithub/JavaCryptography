/* 
 * java.lang.Object
 *     java.security.MessageDigestSpi
 *         java.secuirty.MessageDigest
 *
 * public abstract class class MessageDigest
 * extends MessageDigestSpi
 *
 * This messageDigest class provides applications,
 * the functionlaity of a message digest algorithm,
 * such as SHA-1 or SHA-256.
 *
 * Message digests are secure one-way hash functions
 * that take arbitrary-sized data and output a fixed length hash value.
 *
 * A MessageDigest object starts out initialized.
 * The data is processed through it using the update methods.
 * At any point reset can be called to reset the digest.
 * digest method should be called to complete the hash computation.
 *
 * The digest method can be called once for a given number of updates.
 * After digest has been called, the MessageDigest object is reset to
 * its initialized state.
 *
 */

import java.security.MessageDigest;

public class SHAHashingExample
{
	public static void main(String[] args) throws Exception
	{

		// String data
		String password = "123456";

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// Convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		
		System.out.println("Hex format: " + sb.toString());
	}
}
