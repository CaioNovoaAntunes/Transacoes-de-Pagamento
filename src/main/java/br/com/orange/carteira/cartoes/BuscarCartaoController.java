package br.com.orange.carteira.cartoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class BuscarCartaoController {

    private final CartaoRepository cartaoRepository;

    @Autowired
    public BuscarCartaoController(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaCartao(@PathVariable  Long id) {
        Optional<Cartao> possivelCartao = cartaoRepository.findById(id);
        if(possivelCartao.isEmpty()){
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new BuscaCartaoResponse(possivelCartao.get()));
    }

    /*@GetMapping
    public ResponseEntity<?> buscaPorParam(@PathParam("id")  Long id) {
        Optional<Cartao> possivelCartao = cartaoRepository.findById(id);
        if(possivelCartao.isEmpty()){
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new BuscaCartaoResponse(possivelCartao.get()));
    }
*/

}
