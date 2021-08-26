package br.com.orange.carteira.transacoes;


import br.com.orange.carteira.cartoes.Cartao;
import br.com.orange.carteira.estabelecimentos.NovoEstabelecimento;
import br.com.orange.carteira.produtos.Produto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private NovoEstabelecimento estabelecimento;

    @ManyToOne
    private List<Produto> produto = new ArrayList<>();


    @ManyToOne
    private Cartao cartao;

    @Column(nullable = false)
    private Double valorproduto;

    @Column(nullable = false, updatable = false)
    private LocalDateTime instante = LocalDateTime.now();

    public Transacao(NovoEstabelecimento estabelecimento, List<Produto> produto, Cartao cartao, Double valorproduto) {
        this.estabelecimento = estabelecimento;
        this.produto = produto;
        this.cartao = cartao;
        this.valorproduto = valorproduto;
    }

    public Transacao(NovoEstabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }


    @Deprecated
    public Transacao() {
    }

    public Long getId() {
        return id;
    }



    public Cartao getCartao() {
        return cartao;
    }

    public Double getValorproduto() {
        return valorproduto;
    }

    public NovoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void atualizaEstabelecimento(AtualizaTransacaoRequest atualizar) {
        this.estabelecimento = atualizar.getEstabelecimento();
    }

}
