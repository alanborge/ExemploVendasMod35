/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.domain.jpa.ClienteJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.generic.jpa.IGenericJpaService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericJpaService<ClienteJpa, Long> {

//	Boolean cadastrar(ClienteJpa cliente) throws TipoChaveNaoEncontradaException;
//
	ClienteJpa buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(ClienteJpa cliente) throws TipoChaveNaoEncontradaException;

}
