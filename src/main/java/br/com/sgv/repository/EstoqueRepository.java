package br.com.sgv.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.sgv.model.Estoque;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 */
public interface EstoqueRepository extends CrudRepository<Estoque,Long>{
    
}
