package br.ufg.inf.es.listaval.auth;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CachingSecretProviderDecorator implements SecretProvider {

	private final SecretProvider provider;

	private volatile String secret;

	public CachingSecretProviderDecorator(final SecretProvider provider) {
		this.provider = provider;
	}

	@Override
	public String getSecret() {
		if (secret == null) {
			synchronized (this) {
				if (secret == null) {
					secret = provider.getSecret();
				}
			}
		}

		return secret;
	}
}
