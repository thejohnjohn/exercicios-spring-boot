package br.com.serasa.exerciciossb.controllers;

import br.com.serasa.exerciciossb.models.entities.Produto;

import br.com.serasa.exerciciossb.models.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @PostMapping
    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findById(id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping(path="/pagina/{pagina}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int pagina,
                                                    @PathVariable int qtdePagina) {
        if(qtdePagina >= 5) qtdePagina = 5;
        Pageable pageable = PageRequest.of(pagina, qtdePagina);
        return produtoRepository.findAll(pageable);
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
        //return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
        return produtoRepository.searchByNameLike(parteNome);
    }

    @DeleteMapping (path="/{id}")
    public void excluirProduto(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }

    @PatchMapping
    public Produto alterarProdutoPorId(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }
}
