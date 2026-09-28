package br.com.escola.loja.service;

import br.com.escola.loja.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    List<Produto> listarProdutos(String categoria, String marca, String busca);
    Optional<Produto> buscarPorId(Long id);
    Produto salvar(Produto produto);
    Produto atualizar(Long id, Produto produtoAtualizado);
    void excluir(Long id);
}
