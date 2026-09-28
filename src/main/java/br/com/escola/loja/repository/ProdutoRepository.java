package br.com.escola.loja.repository;

import br.com.escola.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByOrderByIdAsc();
}
