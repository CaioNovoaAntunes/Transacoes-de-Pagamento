package br.com.orange.carteira.estabelecimentos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NovoEstabelecimentoRepository extends JpaRepository<NovoEstabelecimento, Long> {

    Optional<NovoEstabelecimento> findByNome(String nome);
}
