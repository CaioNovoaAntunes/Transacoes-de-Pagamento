package br.com.orange.carteira.cartoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/*
ResponseEntity
HTTP Status, Body Status, Header's, entre outrs coisas que conseguimos verificar no cliente auxiliar, postman, Inmsonia etc
Request - Criação da Request para ter uma borda uma camada em cima da nossa modelo
Any porque no momento o tipo de retorno pode ser qualquer um, porém meu tipo de retorno é de um método que transforma em modelo

EntityManager é um serviço do Jpa que trás alguns métodos prontos de busca, persistência, merge

Repository  é um serviço do spring data jpa que torna mais simples os métodos
de busca,persistência, ele extende de CrudRepository e
 outras classes que trazem métodos que simplificam os serviços de crud

**/
@RestController
@RequestMapping("/cartoes")
public class NovoCartaoController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoCartaoRequest> cadastraCartao(@RequestBody @Valid NovoCartaoRequest request) {
        Cartao possivelCartao = request.paraCartao();

        entityManager.persist(possivelCartao);
        URI uri = ServletUriComponentsBuilder   // gerar uri do recurso que acabou de ser construido
                .fromCurrentRequest() // currente significa da requisição atual
                .path("/{id}")
                .buildAndExpand(possivelCartao.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


}
