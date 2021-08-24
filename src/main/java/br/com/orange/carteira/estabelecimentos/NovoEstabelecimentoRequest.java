package br.com.orange.carteira.estabelecimentos;

import br.com.orange.carteira.validadores.customizado.CPF_CNPJ;

public class NovoEstabelecimentoRequest {
    @CPF_CNPJ
    private String documento;
    private String nome;

    public NovoEstabelecimentoRequest(String documento, String nome) {
        this.documento = documento;
        this.nome = nome;
    }

    public  NovoEstabelecimento paraModelo(){
   return new NovoEstabelecimento(documento, nome);

    }
}
