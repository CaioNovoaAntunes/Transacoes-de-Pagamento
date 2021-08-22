package br.com.orange.carteira.transacoes;

import br.com.orange.carteira.cartoes.Cartao;
import br.com.orange.carteira.cartoes.CartaoRepository;
import br.com.orange.carteira.client.ValidCard;
import br.com.orange.carteira.validador.CheckIfExist;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class TransacaoRequest {
    @NotBlank
    private String estabelecimento;
    @CheckIfExist(klazz = Cartao.class  , field = "numeroCartao")
    @NotBlank
    private String cartao;
    @NotNull
    private Double valorproduto;


    public TransacaoRequest(String estabelecimento, String cartao, Double valorproduto) {
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.valorproduto = valorproduto;
    }

    public Transacao paraTransacao(CartaoRepository cartaoRepository) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumeroCartao(this.cartao);

        return new Transacao(estabelecimento, cartaoOptional.get(), valorproduto);
    }

    public String getCartao(){return this.cartao;}
}
