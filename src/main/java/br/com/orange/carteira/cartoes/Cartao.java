package br.com.orange.carteira.cartoes;

import br.com.orange.carteira.cartoes.TipoCartaoEnum;
import br.com.orange.carteira.transacoes.Transacao;
import br.com.orange.carteira.transacoes.TransacaoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCartao;

    @Enumerated(EnumType.STRING)
    private TipoCartaoEnum tipoCartaoEnum;

    @Column(nullable = false, updatable = false)
    private LocalDateTime instante = LocalDateTime.now();


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
