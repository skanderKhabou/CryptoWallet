package com.mycompany.cryptowallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CryptowalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptowalletApplication.class, args);
	}

	// on va utiliser la méthode reste Template pour pouvoir interroger "binance" à partir de l application on aurai pu aussi utilisrr le WEB CLient pour faire la même chose
	// on délégue à spring la méthode RestTemplate puis on l appelera dans crypto asset ressource

	@Bean // bean Spring va donc invoquer la méthode au démarrage et ajouté au conteneur l'objet de type Rest template il ne reste plus qu a l injecter dans le controller
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
