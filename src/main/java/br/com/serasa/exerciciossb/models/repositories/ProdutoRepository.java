package br.com.serasa.exerciciossb.models.repositories;

import br.com.serasa.exerciciossb.models.entities.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
}
