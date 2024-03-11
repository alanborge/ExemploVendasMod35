/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.dao.jpa.IProdutoJpaDAO;
import br.com.rpires.dao.jpa.generic.jpa.IGenericJpaDAO;
import br.com.rpires.domain.jpa.ProdutoJpa;
import br.com.rpires.services.generic.jpa.GenericJpaService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericJpaService<ProdutoJpa, String> implements IProdutoService {

	public ProdutoService(IGenericJpaDAO<ProdutoJpa, String> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	

}
