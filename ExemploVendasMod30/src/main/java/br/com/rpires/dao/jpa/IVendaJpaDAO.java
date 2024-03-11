/**
 * 
 */
package br.com.rpires.dao.jpa;

import br.com.rpires.dao.jpa.generic.jpa.IGenericJpaDAO;
import br.com.rpires.domain.jpa.VendaJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJpa, String> {

	public void finalizarVenda(VendaJpa vendaJpa) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(VendaJpa vendaJpa) throws TipoChaveNaoEncontradaException, DAOException;
	
	public VendaJpa consultarComCollection(Long id);
}
