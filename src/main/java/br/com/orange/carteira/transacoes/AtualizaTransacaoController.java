package br.com.orange.carteira.transacoes;

import br.com.orange.carteira.cartoes.BuscaCartaoResponse;
import br.com.orange.carteira.cartoes.Cartao;
import br.com.orange.carteira.cartoes.CartaoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AtualizaTransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;
    private CartaoRepository CartaoRepository;

    public AtualizaTransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

}

