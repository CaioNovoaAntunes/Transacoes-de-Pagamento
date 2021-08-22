package br.com.orange.carteira.transacoes;


import br.com.orange.carteira.cartoes.Cartao;

import javax.persistence.*;

@Entity
@Table(name = "tb_transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estabelecimento;
    @ManyToOne
    private Cartao cartao;
    private Double valorproduto;

    public Transacao(String estabelecimento, Cartao cartao, Double valorproduto) {
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.valorproduto = valorproduto;
    }

    @Deprecated
    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Double getValorproduto() {
        return valorproduto;
    }
}
