package br.com.orange.carteira.cartoes;

import br.com.orange.carteira.transacoes.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class BuscarCartaoController {

    private final CartaoRepository cartaoRepository;

    @Autowired
    public BuscarCartaoController(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<?> buscaCartao(@PathVariable  Long id) {
        Optional<Cartao> possivelCartao = cartaoRepository.findById(id);
        if(possivelCartao.isEmpty()){
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new BuscaCartaoResponse(possivelCartao.get()));
    }*/

    @GetMapping
    public ResponseEntity<?> buscaPorParam(@PathParam("id") Long id) { // compondo minha requisição
        if (id != null) { // diferente de nulo parametro vazio

            Optional<Cartao> possivelCartao = cartaoRepository.findById(id);
            return ResponseEntity.ok().body(new BuscaCartaoResponse(possivelCartao.get()));
        }

        List<Cartao> list = cartaoRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
}


