package br.com.orange.carteira.transacoes;

import br.com.orange.carteira.cartoes.Cartao;
import br.com.orange.carteira.estabelecimentos.NovoEstabelecimento;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class BuscaTransacaoResponse {
    private NovoEstabelecimento estabelecimento;
    private Cartao cartao;
    private Double valorproduto;

    public BuscaTransacaoResponse(Transacao transacao) {
        estabelecimento = transacao.getEstabelecimento();
        cartao = transacao.getCartao();
        valorproduto = transacao.getValorproduto();

    }

    public NovoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Double getValorproduto() {
        return valorproduto;
    }
}
