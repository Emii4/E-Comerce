package br.com.escola.loja.controller;

import br.com.escola.loja.model.Produto;
import br.com.escola.loja.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String busca
    ) {
        return produtoService.listarProdutos(categoria, marca, busca);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/produtos")
    public ResponseEntity<?> cadastrarProduto(@Valid @RequestBody Produto produto) {
        validarProduto(produto);
        Produto salvo = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        validarProduto(produto);
        try {
            Produto atualizado = produtoService.atualizar(id, produto);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id) {
        try {
            produtoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    private void validarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }

        if (produto.getDescricao() == null || produto.getDescricao().isBlank()) {
            throw new IllegalArgumentException("Descrição é obrigatória.");
        }

        if (produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }

        if (produto.getEstoque() == null || produto.getEstoque() < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo.");
        }

        if (produto.getMarca() == null || produto.getMarca().isBlank()) {
            throw new IllegalArgumentException("Marca é obrigatória.");
        }

        if (produto.getCategoria() == null || produto.getCategoria().isBlank()) {
            throw new IllegalArgumentException("Categoria é obrigatória.");
        }

        if (produto.getImagem() == null || produto.getImagem().isBlank()) {
            throw new IllegalArgumentException("Imagem é obrigatória.");
        }
    }
}
