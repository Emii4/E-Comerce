package br.com.escola.loja.controller;

import br.com.escola.loja.model.Produto;
import br.com.escola.loja.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAllByOrderByIdAsc();
    }

    @PostMapping("/produtos")
    public ResponseEntity<?> cadastrarProduto(@Valid @RequestBody Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            return ResponseEntity.badRequest().body("Nome é obrigatório.");
        }

        if (produto.getDescricao() == null || produto.getDescricao().isBlank()) {
            return ResponseEntity.badRequest().body("Descrição é obrigatória.");
        }

        if (produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.badRequest().body("Preço deve ser maior que zero.");
        }

        if (produto.getEstoque() == null || produto.getEstoque() < 0) {
            return ResponseEntity.badRequest().body("Estoque não pode ser negativo.");
        }

        Produto salvo = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
