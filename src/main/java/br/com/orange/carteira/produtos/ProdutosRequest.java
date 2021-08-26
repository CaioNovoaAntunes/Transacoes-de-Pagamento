package br.com.orange.carteira.produtos;

import javax.validation.constraints.NotBlank;

public class ProdutosRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public ProdutosRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }


    public Produto toModel() {
        return new Produto(this.nome, this.descricao);
    }
}
