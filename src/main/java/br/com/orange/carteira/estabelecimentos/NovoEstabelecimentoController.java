package br.com.orange.carteira.estabelecimentos;

import br.com.orange.carteira.transacoes.Transacao;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.Properties;

@RestController
@RequestMapping("estabelecimento")
public class NovoEstabelecimentoController {

    private NovoEstabelecimentoRepository novoestabelecimentoRepository;


    @Autowired
    public NovoEstabelecimentoController(NovoEstabelecimentoRepository novoestabelecimentoRepository) {
        this.novoestabelecimentoRepository = novoestabelecimentoRepository;

    }

    @PostMapping
    ResponseEntity<?> cadastraEstabelecimento(@RequestBody @Valid NovoEstabelecimentoRequest request){
        NovoEstabelecimento novoestabelecimento = request.paraModelo();
        boolean estabelecimento = novoestabelecimentoRepository.findByNome(novoestabelecimento.getNome()).isPresent();
        if (estabelecimento == true){
            return ResponseEntity.badRequest().build();
        }

        novoestabelecimentoRepository.save(novoestabelecimento);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoestabelecimento.getId()).toUri();



        return ResponseEntity.created(uri).build();
    }
}
