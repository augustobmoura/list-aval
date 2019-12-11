package br.ufg.inf.es.listaval.auth;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class RandomSecretProvider implements SecretProvider {

	private static final int SECRET_SIZE_IN_BYTES = 64;

	@Override
	public String getSecret() {
		return byteArrayToHex(randomBytes());
	}

	private byte[] randomBytes() {
		final byte[] arr = new byte[SECRET_SIZE_IN_BYTES];
		getRandom().nextBytes(arr);
		return arr;
	}

	private SecureRandom getRandom() {
		try {
			return SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			return new SecureRandom();
		}
	}

	public String byteArrayToHex(final byte[] arr) {
		return IntStream.range(0, arr.length)
			.map(i -> arr[i])
			.mapToObj(b -> String.format("%02x", b))
			.collect(Collectors.joining());
	}

}
