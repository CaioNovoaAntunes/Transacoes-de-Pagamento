package br.com.orange.carteira.cartoes;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/cartoes")
public class NovoCartaoController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastraCartao(@RequestBody @Valid NovoCartaoRequest request) {
        Cartao possivelCartao = request.paraCartao();
        entityManager.persist(possivelCartao);
        URI uri = ServletUriComponentsBuilder  // gerar uri do recurso que acabou de ser construido//
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(possivelCartao.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


}
