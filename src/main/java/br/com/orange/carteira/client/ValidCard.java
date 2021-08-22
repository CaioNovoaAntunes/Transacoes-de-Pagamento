package br.com.orange.carteira.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="validacao", url="http://localhost:8080") // Nome para que serve, {validacao} externa
public interface ValidCard {

    // http://localhost:8080/valida/{caio}
    @GetMapping("/valida/{id}") // Porque o método valida é do tipo Get, URL Tipo do verbo e habilitar no main
    void validarCartao(@PathVariable(value = "id") String cardNumber);

}