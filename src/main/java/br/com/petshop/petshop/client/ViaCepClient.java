package br.com.petshop.petshop.client;

import br.com.petshop.petshop.model.ShippingAdressModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class ViaCepClient {

    private final WebClient webClient;


    public ViaCepClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("viacep.com.br/ws/").build();
    }

    public Mono<ShippingAdressModel> findByCep(String cep){
        log.info("Buscando personagem com o id [{}]", cep);
        return webClient
                .get()
                .uri(cep + "/json/")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ShippingAdressModel.class);
    }
}
