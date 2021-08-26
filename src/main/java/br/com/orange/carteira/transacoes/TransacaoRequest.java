package br.com.orange.carteira.transacoes;

import br.com.orange.carteira.cartoes.Cartao;
import br.com.orange.carteira.cartoes.CartaoRepository;
import br.com.orange.carteira.estabelecimentos.NovoEstabelecimento;
import br.com.orange.carteira.estabelecimentos.NovoEstabelecimentoRepository;
import br.com.orange.carteira.produtos.Produto;
import br.com.orange.carteira.validadores.customizado.CheckIfExist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransacaoRequest {
    @NotBlank
    private Long estabelecimento;
    @CheckIfExist(klazz = Cartao.class  , field = "numeroCartao")
    @NotBlank
    private String cartao;
    @NotNull
    private Double valorproduto;
    private List<Produto> produto = new ArrayList<>();

    public TransacaoRequest(@NotBlank Long estabelecimento, @NotBlank String cartao, @NotNull Double valorproduto, List<Produto> produto) {
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.valorproduto = valorproduto;
        this.produto = produto;
    }

    public Transacao paraTransacao(CartaoRepository cartaoRepository, NovoEstabelecimentoRepository novoEstabelecimentoRepository) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumeroCartao(this.cartao);
        Optional<NovoEstabelecimento> novoEstabelecimentoOptional= novoEstabelecimentoRepository.findById(this.estabelecimento);

        return new Transacao(novoEstabelecimentoOptional.get(),produto, cartaoOptional.get(), valorproduto);
    }

    public String getCartao(){return this.cartao;}
}
