package br.com.orange.carteira.transacoes;


import br.com.orange.carteira.cartoes.Cartao;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String estabelecimento;

    @ManyToOne
    private Cartao cartao;

    @Column(nullable = false)
    private Double valorproduto;

    @Column(nullable = false, updatable = false)
    private LocalDateTime instante = LocalDateTime.now();

    public Transacao(String estabelecimento, Cartao cartao, Double valorproduto) {
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.valorproduto = valorproduto;
    }

    public Transacao(String estabelecimento) {
        this.estabelecimento = estabelecimento;
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

    public void atualizaEstabelecimento(AtualizaTransacaoRequest atualizar) {
        this.estabelecimento = atualizar.getEstabelecimento();
    }

}
