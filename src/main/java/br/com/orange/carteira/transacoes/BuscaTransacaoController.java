package br.com.orange.carteira.transacoes;

import br.com.orange.carteira.cartoes.BuscaCartaoResponse;
import br.com.orange.carteira.cartoes.Cartao;
import br.com.orange.carteira.cartoes.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class BuscaTransacaoController {
    private TransacaoRepository transacaoRepository;

    @Autowired
    public BuscaTransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaCartao(@PathVariable Long id) {
        Optional<Transacao> possivelTransacao = transacaoRepository.findById(id);
        if (possivelTransacao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }



        return ResponseEntity.ok().body(new BuscaTransacaoResponse(possivelTransacao.get()));
    }
}
