package br.com.escola.loja.service;

import br.com.escola.loja.model.Produto;
import br.com.escola.loja.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> listarProdutos(String categoria, String marca, String busca) {
        List<Produto> todos = produtoRepository.findAllByOrderByIdAsc();

        if (categoria == null && marca == null && (busca == null || busca.isBlank())) {
            return todos;
        }

        List<Produto> filtrados = new ArrayList<>();
        for (Produto produto : todos) {
            boolean atendeCategoria = categoria == null || categoria.isBlank()
                    || produto.getCategoria() != null && produto.getCategoria().equalsIgnoreCase(categoria);

            boolean atendeMarca = marca == null || marca.isBlank()
                    || produto.getMarca() != null && produto.getMarca().equalsIgnoreCase(marca);

            boolean atendeBusca = busca == null || busca.isBlank()
                    || produto.getNome() != null && produto.getNome().toLowerCase().contains(busca.toLowerCase())
                    || produto.getDescricao() != null && produto.getDescricao().toLowerCase().contains(busca.toLowerCase());

            if (atendeCategoria && atendeMarca && atendeBusca) {
                filtrados.add(produto);
            }
        }

        return filtrados;
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto existente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));

        existente.setNome(produtoAtualizado.getNome());
        existente.setDescricao(produtoAtualizado.getDescricao());
        existente.setPreco(produtoAtualizado.getPreco());
        existente.setEstoque(produtoAtualizado.getEstoque());
        existente.setMarca(produtoAtualizado.getMarca());
        existente.setCategoria(produtoAtualizado.getCategoria());
        existente.setImagem(produtoAtualizado.getImagem());

        return produtoRepository.save(existente);
    }

    @Override
    public void excluir(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado.");
        }
        produtoRepository.deleteById(id);
    }
}
