package br.ufg.inf.es.listaval.config;

import br.ufg.inf.es.listelab.DisciplinaApi;
import br.ufg.inf.es.listelab.ListaApi;
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
		apiClient.addDefaultHeader("Referer", "http://api.sifo.tech/swagger/index.html");

		br.ufg.inf.es.listelab.invoker.Configuration.setDefaultApiClient(apiClient);

		return apiClient;
	}

	@Bean
	ListaApi listaApi(ApiClient apiClient) {
		return new ListaApi(apiClient);
	}

	@Bean
	DisciplinaApi disciplinaApi(ApiClient apiClient) {
		return new DisciplinaApi(apiClient);
	}

	@Bean
	UsuarioApi usuarioApi(ApiClient apiClient) {
		return new UsuarioApi(apiClient);
	}
}
