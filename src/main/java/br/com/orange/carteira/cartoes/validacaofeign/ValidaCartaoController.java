package br.com.orange.carteira.cartoes.validacaofeign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080/valida/{id}
@RestController
@RequestMapping("/valida")
public class ValidaCartaoController {

    @GetMapping("/{id}")
    public ResponseEntity<?> validaCartao(@PathVariable String id) {

        if(id.startsWith("3")){
         throw new RuntimeException("cartao sem saldo");
        }

        return ResponseEntity.ok().build();
    }
}
