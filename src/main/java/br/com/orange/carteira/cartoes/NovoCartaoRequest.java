package br.com.orange.carteira.cartoes;

import br.com.orange.carteira.validadores.customizado.UniValueValid;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
/*
@Pattern para verificar entre os campos de cada numero do cartão começando com 1 para não ter inicio em zero e máximo nove,
segue a lógica os outros campos do regex




 */

public class NovoCartaoRequest {
    @UniValueValid(klazz = Cartao.class, field = "numeroCartao")
    @Pattern(regexp = "([1-9][0-9][0-9][0-9] [1-9][0-9][0-9][0-9] [1-9][0-9][0-9][0-9] [1-9][0-9][0-9][0-9])", message = "mal formado! esperado: 1000 1000 1000 1000")
    @NotBlank
    @NotNull
    private String numeroCartao;

    @JsonProperty
    @Enumerated(EnumType.STRING)
    private TipoCartaoEnum tipoCartaoEnum;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)// Gera Json da propriedade quando tem apenas um campo
    public NovoCartaoRequest(@NotBlank @NotNull String numeroCartao, TipoCartaoEnum tipoCartaoEnum) {
        this.numeroCartao = numeroCartao;
        this.tipoCartaoEnum = tipoCartaoEnum;
    }

    public Cartao paraCartao() {
        return new Cartao(this.numeroCartao, this.tipoCartaoEnum);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public TipoCartaoEnum getTipoCartaoEnum() {
        return tipoCartaoEnum;
    }

}
