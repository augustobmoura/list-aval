package br.ufg.inf.es.listaval.config;

import br.ufg.inf.es.listelab.UsuarioApi;
import br.ufg.inf.es.listelab.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListElabConfiguration {

	@Bean
	ApiClient listElabApiClient() {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://api.sifo.tech");
		return apiClient;
	}

	@Bean
	UsuarioApi usuarioApi(ApiClient apiClient) {
		return new UsuarioApi(apiClient);
	}
}
