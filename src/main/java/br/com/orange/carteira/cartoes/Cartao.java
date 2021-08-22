package br.com.orange.carteira.cartoes;

import br.com.orange.carteira.cartoes.TipoCartaoEnum;
import br.com.orange.carteira.transacoes.Transacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_cartao")
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCartao;

    @Enumerated(EnumType.STRING)
    private TipoCartaoEnum tipoCartaoEnum;

    public Cartao(@NotBlank @NotNull String numeroCartao, @NotNull @NotBlank TipoCartaoEnum tipoCartaoEnum) {
        this.numeroCartao = numeroCartao;
        this.tipoCartaoEnum = tipoCartaoEnum;
    }


    @Deprecated
    public Cartao() {
    }

    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "numeroCartao='" + numeroCartao + '\'' +
                ", tipoCartaoEnum=" + tipoCartaoEnum +
                '}';
    }

}
