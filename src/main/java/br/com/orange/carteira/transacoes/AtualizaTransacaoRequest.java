package br.com.orange.carteira.transacoes;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class AtualizaTransacaoRequest {
    @NotBlank
    private String estabelecimento;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AtualizaTransacaoRequest(@NotBlank String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }
}
