package br.com.orange.carteira.transacoes;

import br.com.orange.carteira.estabelecimentos.NovoEstabelecimento;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class AtualizaTransacaoRequest {
    @NotBlank
    private NovoEstabelecimento estabelecimento;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AtualizaTransacaoRequest(@NotBlank NovoEstabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void atualizaEstabelecimento(Transacao transacao) {
        this.estabelecimento = transacao.getEstabelecimento();
    }
    public NovoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }
}
