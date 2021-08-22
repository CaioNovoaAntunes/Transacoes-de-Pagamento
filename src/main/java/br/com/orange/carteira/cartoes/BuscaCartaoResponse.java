package br.com.orange.carteira.cartoes;

public class BuscaCartaoResponse {
    private final String numeroCartao;

    public BuscaCartaoResponse(Cartao cartao) {
        numeroCartao = cartao.getNumeroCartao();
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }
}
