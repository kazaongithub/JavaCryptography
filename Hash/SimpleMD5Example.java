/*
 * Simple password security using MD5 algorithm
 *
 * The MD5 Message-Digest Algorithm is a widely used 
 * cryptographic hash function that produces a 128-bit (16-byte) hash value.
 *
 * The basic idea is to map data sets of variable length 
 * to data sets of a fixed length.
 *
 * The input message is split into chunks of 512-bit blocks.
 * A padding is added to the end so that it's length can be divided by 512.
 * These blocks are processed by the MD5 algorithm,
 * which operates in a 128-bit  state and result will be a 128-bit hash value.
 *
 * After applying MD5 generated hash is typically a 32-digit 
 * hexadecimal number.
 *
 */

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class SimpleMD5Example
{
	public static void main(String[] args)
	{
		String passwordToHash = "password";
		String generatedPassword = null;

		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// Add password bytes to digest
			md.update(passwordToHash.getBytes());

			// Get the hash's bytes
			byte[] bytes = md.digest();

			// this bytes[] has bytes in decimal format
			// Convert it to hexadecimal format
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		System.out.println("MD5 hash: " + generatedPassword);
	}
}

